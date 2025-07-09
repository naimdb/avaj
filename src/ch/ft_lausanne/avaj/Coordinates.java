package ch.ft_lausanne.avaj;

public class Coordinates {
    private Integer longitude;
    private Integer latitude;
    private Integer height;

    Coordinates(Integer p_longitude, Integer p_latitude, Integer p_height) {
        if (p_height > 100) {
            p_height = 100;
        }
        this.longitude = p_longitude;
        this.latitude = p_latitude;
        this.height = p_height;
    }

    public Integer getLongitude() { return longitude; }
    public Integer getLatitude() { return latitude; }
    public Integer getHeight() { return height; }
    
    public void setLongitude(Integer longitude) { this.longitude = longitude; }
    public void setLatitude(Integer latitude) { this.latitude = latitude; }
    public void setHeight(Integer height) { this.height = height; }
}