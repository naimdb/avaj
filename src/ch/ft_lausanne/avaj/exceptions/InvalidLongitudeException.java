package ch.ft_lausanne.avaj.exceptions;

public class InvalidLongitudeException extends CoordinateException {
    public InvalidLongitudeException(int longitude) {
        super(String.format("Longitude invalide: %d. Doit être >= 0", longitude));
    }
}