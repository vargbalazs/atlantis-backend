package api.atlantis.service.impl.user;

import api.atlantis.domain.user.AppUser;
import api.atlantis.domain.user.UserPrincipal;
import api.atlantis.enums.Role;
import api.atlantis.exception.domain.*;
import api.atlantis.repository.interfaces.user.UserRepository;
import api.atlantis.service.interfaces.user.UserService;
import api.atlantis.utility.Translator;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

import static api.atlantis.constant.UserImplConstant.*;
import static api.atlantis.enums.Role.ROLE_USER;
import static org.apache.commons.lang3.StringUtils.EMPTY;

@Service
@Transactional
@Qualifier("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {

    private Logger LOGGER = LoggerFactory.getLogger(getClass());
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private LoginAttemptService loginAttemptService;
    private EmailService emailService;

    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder,
                           LoginAttemptService loginAttemptService, EmailService emailService) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.loginAttemptService = loginAttemptService;
        this.emailService = emailService;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        AppUser appUser = userRepository.findAppUserByUserName(userName);
        if (appUser == null) {
            LOGGER.error(NO_USER_FOUND_BY_USERNAME + userName);
            throw new UsernameNotFoundException(Translator.toLocale("NO_USER_FOUND_BY_USERNAME") + userName);
        } else {
            validateLoginAttempt(appUser);
            appUser.setLastLoginDateDisplay(appUser.getLastLoginDate());
            appUser.setLastLoginDate(new Date());
            userRepository.save(appUser);
            UserPrincipal userPrincipal = new UserPrincipal(appUser);
            LOGGER.info(FOUND_USER_BY_USERNAME + userName);
            return userPrincipal;
        }
    }

    private void validateLoginAttempt(AppUser appUser) {
        if (appUser.isNotLocked()) {
            if (loginAttemptService.hasExceededMaxAttempts(appUser.getUserName())) {
                appUser.setNotLocked(false);
            } else {
                appUser.setNotLocked(true);
            }
        } else {
            loginAttemptService.evictUserFromLoginAttemptCache(appUser.getUserName());
        }
    }

    @Override
    public AppUser register(String firstName, String lastName, String userName, String email)
            throws UserNotFoundException, EmailExistException, UserNameExistException, MessagingException {
        validateNewUserNameAndEmail(EMPTY, userName, email);
        AppUser user = new AppUser();
        user.setUserId(generateUserId());
        String password = generatePassword();
        String encodedPassword = encodePassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUserName(userName);
        user.setEmail(email);
        user.setJoinDate(new Date());
        user.setPassword(encodedPassword);
        user.setActive(true);
        user.setNotLocked(true);
        user.setFirstLogin(true);
        user.setRole(ROLE_USER.name());
        user.setAuthorities(ROLE_USER.getAuthorities());
        userRepository.save(user);
//        LOGGER.info("New user password: " + password);
        emailService.sendNewPasswordEmail(firstName, password, email);
        return user;
    }

    @Override
    public AppUser addNewUser(String firstName, String lastName, String userName, String email, String role,
                              boolean isNonLocked, boolean isActive)
            throws UserNotFoundException, EmailExistException, UserNameExistException {
        validateNewUserNameAndEmail(EMPTY, userName, email);
        AppUser user = new AppUser();
        user.setUserId(generateUserId());
        String password = generatePassword();
        String encodedPassword = encodePassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUserName(userName);
        user.setEmail(email);
        user.setJoinDate(new Date());
        user.setPassword(encodedPassword);
        user.setActive(isActive);
        user.setNotLocked(isNonLocked);
        user.setRole(getRoleEnumName(role).name());
        user.setAuthorities(getRoleEnumName(role).getAuthorities());
        userRepository.save(user);
        return user;
    }

    private Role getRoleEnumName(String role) {
        return Role.valueOf(role.toUpperCase());
    }

    @Override
    public AppUser updateUser(String currentUserName, String firstName, String lastName, String userName, String email,
                              String role, boolean isNonLocked, boolean isActive)
            throws UserNotFoundException, EmailExistException, UserNameExistException {
        AppUser currentUser = validateNewUserNameAndEmail(currentUserName, userName, email);
        currentUser.setFirstName(firstName);
        currentUser.setLastName(lastName);
        currentUser.setUserName(userName);
        currentUser.setEmail(email);
        currentUser.setActive(isActive);
        currentUser.setNotLocked(isNonLocked);
        currentUser.setRole(getRoleEnumName(role).name());
        currentUser.setAuthorities(getRoleEnumName(role).getAuthorities());
        userRepository.save(currentUser);
        return currentUser;
    }

    @Override
    public void deleteUser(long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public void resetPassword(String email) throws EmailNotFoundException {
        AppUser user = userRepository.findAppUserByUserEmail(email);
        if (user == null) {
            throw new EmailNotFoundException(Translator.toLocale("NO_USER_FOUND_BY_EMAIL") + email);
        }
        String password = generatePassword();
        user.setPassword(encodePassword(password));
        userRepository.save(user);
        emailService.sendNewPasswordEmail(user.getFirstName(), password, email);
    }

    @Override
    public void changePassword(String userName, String oldPassword, String newPassword, String confirmPassword)
            throws UsernameNotFoundException, PasswordNotMatchException, OldPasswordNotMatchException {
        AppUser user = userRepository.findAppUserByUserName(userName);
        if (user == null) {
            throw new UsernameNotFoundException(Translator.toLocale("NO_USER_FOUND_BY_USERNAME") + userName);
        }
        if (!newPassword.equals(confirmPassword)) {
            throw new PasswordNotMatchException(Translator.toLocale("PASSWORD_NOT_MATCH"));
        }
        if (!bCryptPasswordEncoder.matches(oldPassword, user.getPassword())) {
            throw new OldPasswordNotMatchException(Translator.toLocale("OLD_PASSWORD_NOT_MATCH"));
        }
        user.setPassword(bCryptPasswordEncoder.encode(newPassword));
        userRepository.save(user);
    }

    private String encodePassword(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

    private String generatePassword() {
        return RandomStringUtils.randomAlphanumeric(10);
    }

    private String generateUserId() {
        return RandomStringUtils.randomNumeric(10);
    }

    private AppUser validateNewUserNameAndEmail(String currentUserName, String newUserName, String newEmail)
            throws UserNotFoundException, UserNameExistException, EmailExistException {
        AppUser userByNewUsername = findUserByUserName(newUserName);
        AppUser userByNewEmail = findUserByEmail(newEmail);
        if (StringUtils.isNotBlank(currentUserName)) {
            AppUser currentUser = findUserByUserName(currentUserName);
            if (currentUser == null) {
                throw new UserNotFoundException(Translator.toLocale("NO_USER_FOUND_BY_USERNAME") + currentUserName);
            }
            if (userByNewUsername != null && !currentUser.getId().equals(userByNewUsername.getId())) {
                throw new UserNameExistException(Translator.toLocale("USERNAME_ALREADY_EXISTS"));
            }
            if (userByNewEmail != null && !currentUser.getId().equals(userByNewEmail.getId())) {
                throw new EmailExistException(Translator.toLocale("EMAIL_ALREADY_EXISTS"));
            }
            return currentUser;
        } else {
            if (userByNewUsername != null) {
                throw new UserNameExistException(Translator.toLocale("USERNAME_ALREADY_EXISTS"));
            }
            if (userByNewEmail != null) {
                throw new EmailExistException(Translator.toLocale("EMAIL_ALREADY_EXISTS"));
            }
            return null;
        }
    }

    @Override
    public List<AppUser> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public AppUser findUserByUserName(String userName) {
        return userRepository.findAppUserByUserName(userName);
    }

    @Override
    public AppUser findUserByEmail(String email) {
        return userRepository.findAppUserByUserEmail(email);
    }

    @Override
    public void setFirstLogin(String userName, boolean value) {
        AppUser user = userRepository.findAppUserByUserName(userName);
        user.setFirstLogin(value);
        userRepository.save(user);
    }
}
