package ch.ft_lausanne.avaj.exceptions;

public class InvalidAircraftNameException extends AircraftException {
    public InvalidAircraftNameException(String name) {
        super(String.format("Nom d'aéronef invalide: '%s'. Format requis: commence par une majuscule suivie de lettres minuscules et chiffres", name));
    }
}
