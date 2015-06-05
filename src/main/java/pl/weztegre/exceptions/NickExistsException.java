package pl.weztegre.exceptions;

/**
* Klasa wyjątku.
* Rzucana gdy podany nick użytkownika już jest zapisany w bazie.
*/
public class NickExistsException extends Throwable {
    public NickExistsException(String message) {
        super(message);
    }
}
