package ch.ft_lausanne.avaj.exceptions;

public class AircraftException extends AvajException {
    public AircraftException(String message) {
        super(message);
    }

    public AircraftException(String message, Throwable cause) {
        super(message, cause);
    }
}