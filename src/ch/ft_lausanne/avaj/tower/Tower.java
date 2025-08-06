package ch.ft_lausanne.avaj.tower;

import java.util.ArrayList;
import java.util.List;
import ch.ft_lausanne.avaj.Simulation;
import ch.ft_lausanne.avaj.aircraft.Flyable;

public class Tower {
    private List<Flyable> observers = new ArrayList<>();

    public void register(Flyable p_flyable){
        observers.add(p_flyable);
		p_flyable.registerTower((WeatherTower) this);
    }

    public void unregister(Flyable p_flyable){
        Simulation.landingLog(p_flyable);
        observers.remove(p_flyable);
    }

protected void conditionChanged(){
        List<Flyable> observersCopy = new ArrayList<>(observers);
        for (Flyable observer : observersCopy) {
            observer.updateConditions();
            if (observer.getCoordinate().getHeight() <= 0) {
                unregister(observer);
            }
        }
    }
}