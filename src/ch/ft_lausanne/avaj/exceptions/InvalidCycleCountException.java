package ch.ft_lausanne.avaj.exceptions;

public class InvalidCycleCountException extends ScenarioException {
    public InvalidCycleCountException(String value) {
        super(String.format("Nombre de cycles invalide: '%s'. Doit être un entier positif.", value));
    }
}