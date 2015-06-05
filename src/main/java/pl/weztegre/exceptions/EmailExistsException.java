package pl.weztegre.exceptions;

/**
* Klasa wyjątku.
* Rzucana gdy podany adres e-mail już jest zapisany w bazie.
*/
public class EmailExistsException extends Throwable {
    public EmailExistsException(String message) {
        super(message);
    }
}
