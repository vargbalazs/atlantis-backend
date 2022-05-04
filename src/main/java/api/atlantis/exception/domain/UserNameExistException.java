package api.atlantis.exception.domain;

public class UserNameExistException extends Exception{
    public UserNameExistException(String message) {
        super(message);
    }
}
