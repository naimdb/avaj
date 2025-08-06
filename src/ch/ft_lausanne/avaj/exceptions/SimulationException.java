package ch.ft_lausanne.avaj.exceptions;

public class SimulationException extends AvajException {
    public SimulationException(String message) {
        super(message);
    }

    public SimulationException(String message, Throwable cause) {
        super(message, cause);
    }
}
