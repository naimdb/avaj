package ch.ft_lausanne.avaj.exceptions;

public class LogFileException extends FileException {
    public LogFileException(String message, Throwable cause) {
        super("Erreur lors de l'écriture du fichier de log: " + message, cause);
    }
}