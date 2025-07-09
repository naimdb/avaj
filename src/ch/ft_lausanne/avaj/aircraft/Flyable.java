package ch.ft_lausanne.avaj.aircraft;

import ch.ft_lausanne.avaj.Coordinates;
import ch.ft_lausanne.avaj.tower.WeatherTower;

public interface Flyable {
    abstract void updateConditions();
    void registerTower(WeatherTower p_tower);
    Long getId();
    String getName();
    Coordinates getCoordinate();
}