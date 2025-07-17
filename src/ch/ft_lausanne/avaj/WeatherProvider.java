package ch.ft_lausanne.avaj;

public class WeatherProvider {
    private static WeatherProvider instance = null;
    private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider() {}

    public static WeatherProvider getInstance() {
        if (instance == null) {
            instance = new WeatherProvider();
        }
        return instance;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int index = (coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight()) % weather.length;
        return weather[index];
    }
}