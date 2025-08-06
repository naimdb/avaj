package ch.ft_lausanne.avaj.exceptions;

public class InvalidLatitudeException extends CoordinateException {
    public InvalidLatitudeException(int latitude) {
        super(String.format("Latitude invalide: %d. Doit être >= 0", latitude));
    }
}