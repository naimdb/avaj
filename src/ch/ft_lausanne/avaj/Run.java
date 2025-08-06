package ch.ft_lausanne.avaj;

import ch.ft_lausanne.avaj.tower.WeatherTower;

public class Run {
    public static void runSimulator(Long nbLog, WeatherTower weatherTower) {
        for (int i = 0; i < nbLog; i++) {
            weatherTower.changeWeather();
        }
    }
}