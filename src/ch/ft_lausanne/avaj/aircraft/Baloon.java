package ch.ft_lausanne.avaj.aircraft;

import ch.ft_lausanne.avaj.Coordinates;
import ch.ft_lausanne.avaj.Simulation;
import ch.ft_lausanne.avaj.tower.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
    Long id;
    String name;
    Coordinates coordinate;

    public Baloon(Long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
    }

    public void updateConditions(String weather) {
        switch (weather) {
            case "SUN" -> {
                coordinate.setLongitude(coordinate.getLongitude() + 2);
                coordinate.setHeight(coordinate.getHeight() + 4);
                String msg = "Balloon profite du beau temps ! ☀️";
                Simulation.flyableLog(msg, this);
            }
            case "RAIN" -> {
                coordinate.setHeight(coordinate.getHeight() - 5);
                String msg = "Balloon descend à cause de la pluie ! ⛈️";
                Simulation.flyableLog(msg, this);
            }
            case "FOG" -> {
                coordinate.setHeight(coordinate.getHeight() - 3);
                String msg = "Balloon perd de l'altitude dans le brouillard ! 🌁";
                Simulation.flyableLog(msg, this);
            }
            case "SNOW" -> {
                coordinate.setHeight(coordinate.getHeight() - 15);
                String msg = "Balloon tombe rapidement à cause de la neige ! 🌨️";
                Simulation.flyableLog(msg, this);
            }
            default -> {
                String msg = "Météo inconnue pour le balloon !";
                Simulation.flyableLog(msg, this);
            }
        }
    }

    public void registerTower(WeatherTower p_tower) {
        Simulation.registerLog(this);
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public Coordinates getCoordinate() { return coordinate; }
}