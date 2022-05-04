package api.atlantis.service.interfaces.user;

import api.atlantis.domain.user.AppUser;
import api.atlantis.exception.domain.*;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.mail.MessagingException;
import java.util.List;

public interface UserService {

    AppUser register(String firstName, String lastName, String userName, String email) throws UserNotFoundException, EmailExistException, UserNameExistException, MessagingException;

    List<AppUser> getUsers();

    AppUser findUserByUserName(String userName);

    AppUser findUserByEmail(String email);

    AppUser addNewUser(String firstName, String lastName, String userName, String email, String role,
                       boolean isNonLocked, boolean isActive) throws UserNotFoundException, EmailExistException, UserNameExistException;

    AppUser updateUser(String currentUserName, String firstName, String lastName, String userName, String email,
                       String role, boolean isNonLocked, boolean isActive) throws UserNotFoundException, EmailExistException, UserNameExistException;

    void deleteUser(long userId);

    void resetPassword(String email) throws EmailNotFoundException;

    void changePassword(String userName, String oldPassword, String newPassword, String confirmPassword)
            throws UsernameNotFoundException, PasswordNotMatchException, OldPasswordNotMatchException;

    void setFirstLogin(String userName, boolean value);
}
