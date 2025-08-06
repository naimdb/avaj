package ch.ft_lausanne.avaj.exceptions;

public class FileException extends AvajException {
    public FileException(String message) {
        super(message);
    }

    public FileException(String message, Throwable cause) {
        super(message, cause);
    }
}