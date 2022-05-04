package api.atlantis.resource.user;

import api.atlantis.domain.user.AppUser;
import api.atlantis.domain.http.HttpResponse;
import api.atlantis.domain.user.ChangePassword;
import api.atlantis.domain.user.UserPrincipal;
import api.atlantis.exception.domain.*;
import api.atlantis.mapstruct.dto.user.*;
import api.atlantis.mapstruct.mappers.user.AppUserMapper;
import api.atlantis.mapstruct.mappers.user.ChangePasswordMapper;
import api.atlantis.service.interfaces.user.UserService;
import api.atlantis.utility.JWTTokenProvider;
import api.atlantis.utility.Translator;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

import java.util.List;

import static api.atlantis.constant.SecurityConstant.JWT_TOKEN_HEADER;

@RestController
@RequestMapping(path = {"/api/user"})
public class UserResource extends ExceptionHandling {

    public static final String EMAIL_SENT = "An e-mail with a new password was sent to: "; // translated
    public static final String USER_DELETED_SUCCESSFULLY = "User deleted successfully"; // translated

    private UserService userService;
    private AuthenticationManager authenticationManager;
    private JWTTokenProvider jwtTokenProvider;
    private AppUserMapper appUserMapper;
    private ChangePasswordMapper changePasswordMapper;

    public UserResource(UserService userService, AuthenticationManager authenticationManager,
                        JWTTokenProvider jwtTokenProvider, AppUserMapper appUserMapper,
                        ChangePasswordMapper changePasswordMapper) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.appUserMapper = appUserMapper;
        this.changePasswordMapper = changePasswordMapper;
    }

    @PostMapping("/signup")
    public ResponseEntity<AppUserDto> signup(@RequestBody AppUserDto appUserDto) throws UserNotFoundException,
            EmailExistException, UserNameExistException, MessagingException {
        AppUser appUser = appUserMapper.toEntity(appUserDto);
        AppUser newUser = userService.register(appUser.getFirstName(), appUser.getLastName(), appUser.getUserName(),
                appUser.getEmail());
        return new ResponseEntity<>(appUserMapper.toDto(newUser), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<AppUserDto> login(@RequestBody AppUserLoginDto appUserLoginDto) {
        AppUser appUser = appUserMapper.toLoginUser(appUserLoginDto);
        authenticate(appUser.getUserName(), appUser.getPassword());
        AppUser loginUser = userService.findUserByUserName(appUser.getUserName());
        UserPrincipal userPrincipal = new UserPrincipal(loginUser);
        HttpHeaders jwtHeader = getJwtHeader(userPrincipal);
        return new ResponseEntity<>(appUserMapper.toDto(loginUser), jwtHeader, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<AppUserDto> addNewUser(@RequestBody AppUserDto appUserDto) throws UserNotFoundException,
            EmailExistException, UserNameExistException {
        AppUser appUser = appUserMapper.toEntity(appUserDto);
        AppUser newUser = userService.addNewUser(appUser.getFirstName(), appUser.getLastName(), appUser.getUserName(),
                appUser.getEmail(), appUser.getRole(), appUser.isNotLocked(), appUser.isActive());
        return new ResponseEntity<>(appUserMapper.toDto(newUser), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<AppUserDto> update(@RequestBody AppUserDto appUserDto)
            throws UserNotFoundException, EmailExistException, UserNameExistException {
        AppUser appUser = appUserMapper.toEntity(appUserDto);
        AppUser user = userService.updateUser(appUserDto.getCurrentUserName(), appUser.getFirstName(), appUser.getLastName(),
                appUser.getUserName(), appUser.getEmail(), appUser.getRole(), appUser.isNotLocked(), appUser.isActive());
        return new ResponseEntity<>(appUserMapper.toDto(user), HttpStatus.OK);
    }

    @GetMapping("/find/{username}")
    public ResponseEntity<AppUserDto> getUser(@PathVariable("username") String userName) {
        AppUser user = userService.findUserByUserName(userName);
        return new ResponseEntity<>(appUserMapper.toDto(user), HttpStatus.OK);
    }

    @GetMapping("/usernameexists/{username}")
    public ResponseEntity userNameExists(@PathVariable("username") String userName) {
        AppUser user = userService.findUserByUserName(userName);
        boolean userExists = user != null;
        return new ResponseEntity(userExists, HttpStatus.OK);
    }

    @GetMapping("/useremailexists/{useremail}")
    public ResponseEntity userEmailExists(@PathVariable("useremail") String userEmail) {
        AppUser user = userService.findUserByEmail(userEmail);
        boolean userExists = user != null;
        return new ResponseEntity(userExists, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<AppUserDto>> getAllUsers() {
        List<AppUserDto> users = appUserMapper.toListDto(userService.getUsers());
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/resetpassword/{email}")
    public ResponseEntity<HttpResponse> resetPassword(@PathVariable("email") String email) throws EmailNotFoundException {
        AppUser appUser = userService.findUserByEmail(email);
        userService.resetPassword(appUser.getEmail());
        return response(HttpStatus.OK, Translator.toLocale("EMAIL_SENT") + appUser.getEmail());
    }

    @GetMapping("/forgotpassword/{email}")
    public ResponseEntity<HttpResponse> forgotPassword(@PathVariable("email") String email) throws EmailNotFoundException {
        AppUser appUser = userService.findUserByEmail(email);
        userService.resetPassword(appUser.getEmail());
        return response(HttpStatus.OK, Translator.toLocale("EMAIL_SENT") + appUser.getEmail());
    }

    @PostMapping("/changepassword")
    public ResponseEntity<HttpResponse> changePassword(@RequestBody ChangePasswordDto changePasswordDto)
            throws UsernameNotFoundException, PasswordNotMatchException, OldPasswordNotMatchException {
        ChangePassword changePassword = changePasswordMapper.toEntity(changePasswordDto);
        userService.changePassword(changePassword.getUserName(), changePassword.getOldPassword(),
                changePassword.getNewPassword(), changePassword.getConfirmPassword());
        return response(HttpStatus.OK, Translator.toLocale("PASSWORD_CHANGED"));
    }

    @PostMapping("/firstlogin/{username}")
    public ResponseEntity<HttpResponse> setFirstLogin(@PathVariable("username") String username) {
        userService.setFirstLogin(username, false);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('user:delete')")
    public  ResponseEntity<HttpResponse> deleteUser(@PathVariable("id") long userId) {
        userService.deleteUser(userId);
        return response(HttpStatus.NO_CONTENT, Translator.toLocale("USER_DELETED_SUCCESSFULLY"));
    }

    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        HttpResponse body = new HttpResponse();
        body.setHttpStatusCode(httpStatus.value());
        body.setHttpStatus(httpStatus);
        body.setReason(httpStatus.getReasonPhrase().toUpperCase());
        body.setMessage(message);
        return new ResponseEntity<>(body, httpStatus);
    }

    private HttpHeaders getJwtHeader(UserPrincipal userPrincipal) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(JWT_TOKEN_HEADER, jwtTokenProvider.generateJwtToken(userPrincipal));
        return headers;
    }

    private void authenticate(String userName, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
    }
}
