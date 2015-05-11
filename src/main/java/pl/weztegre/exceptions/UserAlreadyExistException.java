package pl.weztegre.exceptions;

/**
* Klasa wyjątku.
* Rzucana gdy użytkownik już jest zapisany w bazie.
*/
public class UserAlreadyExistException extends Throwable {
    public UserAlreadyExistException() {
            }
    public UserAlreadyExistException(String message) {
        super(message);
    }
}
