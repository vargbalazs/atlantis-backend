package api.atlantis.exception.domain;

import api.atlantis.domain.http.HttpResponse;
import api.atlantis.utility.Translator;
import com.auth0.jwt.exceptions.TokenExpiredException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.NoResultException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class ExceptionHandling implements ErrorController {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    private static final String ACCOUNT_LOCKED = "Your account has been locked. Please contact administration"; // translated
    private static final String METHOD_IS_NOT_ALLOWED = "This request method is not allowed on this endpoint. Please send a '%s' request"; // translated
    private static final String INTERNAL_SERVER_ERROR_MSG = "An error occurred while processing the request"; // translated
    private static final String INCORRECT_CREDENTIALS = "Username / password incorrect. Please try again"; // translated
    private static final String ACCOUNT_DISABLED = "Your account has been disabled. If this is an error, please contact administration"; // translated
    private static final String ERROR_PROCESSING_FILE = "Error occurred while processing file"; // translated
    private static final String NOT_ENOUGH_PERMISSION = "You do not have enough permission"; // translated
    private static final String VALIDATION_FAILED = "Not valid data was sent"; // translated

    @ExceptionHandler(DisabledException.class)
    public ResponseEntity<HttpResponse> accountDisabledException() {
        return createHttpResponse(BAD_REQUEST, Translator.toLocale("ACCOUNT_DISABLED"));
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<HttpResponse> badCredentialsException() {
        return createHttpResponse(BAD_REQUEST, Translator.toLocale("INCORRECT_CREDENTIALS"));
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<HttpResponse> accessDeniedException() {
        return createHttpResponse(FORBIDDEN, Translator.toLocale("NOT_ENOUGH_PERMISSION"));
    }

    @ExceptionHandler(LockedException.class)
    public ResponseEntity<HttpResponse> lockedException() {
        return createHttpResponse(UNAUTHORIZED, Translator.toLocale("ACCOUNT_LOCKED"));
    }

    @ExceptionHandler(TokenExpiredException.class)
    public ResponseEntity<HttpResponse> tokenExpiredException(TokenExpiredException exception) {
        return createHttpResponse(UNAUTHORIZED, exception.getMessage());
    }

    @ExceptionHandler(EmailExistException.class)
    public ResponseEntity<HttpResponse> emailExistException(EmailExistException exception) {
        return createHttpResponse(BAD_REQUEST, exception.getMessage());
    }

    @ExceptionHandler(UserNameExistException.class)
    public ResponseEntity<HttpResponse> usernameExistException(UserNameExistException exception) {
        return createHttpResponse(BAD_REQUEST, exception.getMessage());
    }

    @ExceptionHandler(EmailNotFoundException.class)
    public ResponseEntity<HttpResponse> emailNotFoundException(EmailNotFoundException exception) {
        return createHttpResponse(BAD_REQUEST, exception.getMessage());
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<HttpResponse> userNotFoundException(UserNotFoundException exception) {
        return createHttpResponse(BAD_REQUEST, exception.getMessage());
    }

    @ExceptionHandler(PasswordNotMatchException.class)
    public ResponseEntity<HttpResponse> passwordNotMatchException(PasswordNotMatchException exception) {
        return createHttpResponse(BAD_REQUEST, exception.getMessage());
    }

    @ExceptionHandler(OldPasswordNotMatchException.class)
    public ResponseEntity<HttpResponse> oldPasswordNotMatchException(OldPasswordNotMatchException exception) {
        return createHttpResponse(BAD_REQUEST,exception.getMessage());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<HttpResponse> methodNotSupportedException(HttpRequestMethodNotSupportedException exception) {
        HttpMethod supportedMethod = Objects.requireNonNull(exception.getSupportedHttpMethods()).iterator().next();
        return createHttpResponse(METHOD_NOT_ALLOWED, Translator.toLocale("METHOD_IS_NOT_ALLOWED") + supportedMethod);
    }

    @ExceptionHandler(NotOfficeXmlFileException.class)
    public ResponseEntity<HttpResponse> wrongFileFormat(NotOfficeXmlFileException exception) {
        return createHttpResponse(INTERNAL_SERVER_ERROR, Translator.toLocale("WRONG_FILE_FORMAT"));
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<HttpResponse> iOException(IOException exception) {
        LOGGER.error(exception.getMessage());
        return createHttpResponse(INTERNAL_SERVER_ERROR, Translator.toLocale("ERROR_PROCESSING_FILE"));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<HttpResponse> dataIntegrityViolationException(DataIntegrityViolationException exception) {
        return createHttpResponse(INTERNAL_SERVER_ERROR, Translator.toLocale("DATA_INTEGRITY"));
    }

    protected ResponseEntity<HttpResponse> createHttpResponse(HttpStatus httpStatus, String message) {
        HttpResponse httpResponse = new HttpResponse(httpStatus.value(), httpStatus,
                httpStatus.getReasonPhrase().toUpperCase(), message);
        return new ResponseEntity<>(httpResponse, httpStatus);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<HttpResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException exception)
    {
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });
        HttpResponse httpResponse = new HttpResponse(BAD_REQUEST.value(), BAD_REQUEST,
                BAD_REQUEST.getReasonPhrase().toUpperCase(), Translator.toLocale("VALIDATION_FAILED"), errors);
        return new ResponseEntity<>(httpResponse, BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<HttpResponse> internalServerErrorException(Exception exception) {
        LOGGER.error(exception.getMessage());
        return createHttpResponse(INTERNAL_SERVER_ERROR, Translator.toLocale("INTERNAL_SERVER_ERROR_MSG"));
    }

    @ExceptionHandler(NoResultException.class)
    public ResponseEntity<HttpResponse> notFoundException(NoResultException exception) {
        LOGGER.error(exception.getMessage());
        return createHttpResponse(NOT_FOUND, exception.getMessage());
    }

}
