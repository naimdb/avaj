package ch.ft_lausanne.avaj.exceptions;

public class InvalidScenarioFormatException extends ScenarioException {
    public InvalidScenarioFormatException(String message) {
        super("Format de scénario invalide: " + message);
    }
}
