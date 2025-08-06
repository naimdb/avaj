package ch.ft_lausanne.avaj.exceptions;

public class ScenarioException extends AvajException {
    public ScenarioException(String message) {
        super(message);
    }

    public ScenarioException(String message, Throwable cause) {
        super(message, cause);
    }
}
