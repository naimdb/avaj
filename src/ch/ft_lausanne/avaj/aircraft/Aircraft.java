package ch.ft_lausanne.avaj.aircraft;

import ch.ft_lausanne.avaj.Coordinates;

public abstract class Aircraft {
    protected Long id;
    protected String name;
    protected Coordinates coordinates;

    protected Aircraft(Long p_id, String p_name, Coordinates p_coordinate) {
        this.id = p_id;
        this.name = p_name;
        this.coordinates = p_coordinate;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public Coordinates getCoordinates() { return coordinates; }
    public void setCoordinates(Coordinates coordinates) { this.coordinates = coordinates; }
}