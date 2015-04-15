package pl.weztegre.exceptions;

public class NickExistsException extends Throwable {
    public NickExistsException(String message) {
        super(message);
    }
}
