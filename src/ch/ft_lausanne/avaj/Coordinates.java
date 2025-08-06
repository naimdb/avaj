package ch.ft_lausanne.avaj;

public class Coordinates {
    private Integer longitude;
    private Integer latitude;
    private Integer height;

    Coordinates(Integer p_longitude, Integer p_latitude, Integer p_height) {
        this.longitude = Math.max(0, p_longitude);
        this.latitude = Math.max(0, p_latitude);
        this.height = Math.min(100, Math.max(0, p_height));
    }

    public Integer getLongitude() { return longitude; }
    public Integer getLatitude() { return latitude; }
    public Integer getHeight() { return height; }
    
    public void setLongitude(Integer longitude) { 
        this.longitude = Math.max(0, longitude); 
    }
    
    public void setLatitude(Integer latitude) { 
        this.latitude = Math.max(0, latitude); 
    }
    
    public void setHeight(Integer height) { 
        this.height = Math.min(100, Math.max(0, height)); 
    }
}