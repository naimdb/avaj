package ch.ft_lausanne.avaj.exceptions;

public class UnknownAircraftTypeException extends AircraftException {
    public UnknownAircraftTypeException(String type) {
        super(String.format("Type d'aéronef inconnu: '%s'. Types valides: Helicopter, JetPlane, Baloon", type));
    }
}
