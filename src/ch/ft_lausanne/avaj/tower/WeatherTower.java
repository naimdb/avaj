package ch.ft_lausanne.avaj.tower;

import ch.ft_lausanne.avaj.Coordinates;
import ch.ft_lausanne.avaj.WeatherProvider;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getInstance().getCurrentWeather(coordinates);
    }

    public void changeWeather() {
        conditionsChanged();
    }

    private void conditionsChanged() {
    }
}
