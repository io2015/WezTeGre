package pl.weztegre.exceptions;

public class UserAlreadyExistException extends Throwable {
    public UserAlreadyExistException() {
            }
    public UserAlreadyExistException(String message) {
        super(message);
    }
}
