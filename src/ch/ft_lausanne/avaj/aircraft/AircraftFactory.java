package ch.ft_lausanne.avaj.aircraft;

import ch.ft_lausanne.avaj.Coordinates;

public class AircraftFactory {
    private static AircraftFactory instance = null;
    
    private AircraftFactory() {}
    
    public static AircraftFactory getInstance() {
        if (instance == null) {
            instance = new AircraftFactory();
        }
        return instance;
    }

    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
        return switch (p_type) {
            case "Helicopter" -> new Helicopter(1L, p_name, p_coordinates);
            case "JetPlane" -> new JetPlane(1L, p_name, p_coordinates);
            case "Baloon" -> new Baloon(1L, p_name, p_coordinates);
            default -> null;
        };
    }
}