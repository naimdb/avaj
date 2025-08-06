package ch.ft_lausanne.avaj.exceptions;

public class InvalidHeightException extends CoordinateException {
    public InvalidHeightException(int height) {
        super(String.format("Hauteur invalide: %d. Doit être >= 0", height));
    }
}