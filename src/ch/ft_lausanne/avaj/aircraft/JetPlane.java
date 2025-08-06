package ch.ft_lausanne.avaj.aircraft;

import ch.ft_lausanne.avaj.Coordinates;
import ch.ft_lausanne.avaj.Simulation;
import ch.ft_lausanne.avaj.tower.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
    protected WeatherTower weatherTower;

    public JetPlane(Long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
    }

    public void updateConditions() {
        if (weatherTower == null) return;
        
        String weather = weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "SUN" -> {
                coordinates.setLongitude(coordinates.getLongitude() + 10);
                coordinates.setHeight(coordinates.getHeight() + 2);
                String msg = "Fantastique, droit vers le soleil. Est-ce une bonne idée ??? ☀️";
                Simulation.flyableLog(msg, this);
            }
            case "RAIN" -> {
                coordinates.setLongitude(coordinates.getLongitude() + 5);
                String msg = "Accrochez-vous, ca va secouer !!! ⛈️";
                Simulation.flyableLog(msg, this);
            }
            case "FOG" -> {
                coordinates.setLongitude(coordinates.getLongitude() + 1);
                String msg = "Je vois rien dans cette purée de pois !! 🌁";
                Simulation.flyableLog(msg, this);
            }
            case "SNOW" -> {
                coordinates.setHeight(coordinates.getHeight() - 7);
                String msg = "Mais il neige ? Mais c'est impossible !!! 🌨️";
                Simulation.flyableLog(msg, this);
            }
        }
    }

    public void registerTower(WeatherTower p_tower) {
        this.weatherTower = p_tower;
        Simulation.registerLog(this);
    }

    public Coordinates getCoordinate() { return coordinates; }
}
