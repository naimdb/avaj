package ch.ft_lausanne.avaj.exceptions;

public class ScenarioFileNotFoundException extends FileException {
    public ScenarioFileNotFoundException(String filename) {
        super(String.format("Fichier de scénario introuvable: '%s'", filename));
    }
}