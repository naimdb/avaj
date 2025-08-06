package ch.ft_lausanne.avaj.aircraft;

import ch.ft_lausanne.avaj.Coordinates;

public class AircraftFactory {
    private static AircraftFactory instance = null;
    private static Long nextId = 1L;
    
    private AircraftFactory() {}
    
    public static AircraftFactory getInstance() {
        if (instance == null) {
            instance = new AircraftFactory();
        }
        return instance;
    }

    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
        Long id = nextId++;
        return switch (p_type) {
            case "Helicopter" -> new Helicopter(id, p_name, p_coordinates);
            case "JetPlane" -> new JetPlane(id, p_name, p_coordinates);
            case "Baloon" -> new Baloon(id, p_name, p_coordinates);
            default -> null;
        };
    }
}