package ch.ft_lausanne.avaj.tower;

import java.util.ArrayList;
import java.util.List;
import ch.ft_lausanne.avaj.Simulation;
import ch.ft_lausanne.avaj.aircraft.Flyable;

public class Tower {
    private List<Flyable> observers = new ArrayList<>();

    public void register(Flyable p_flyable){
        String msg = "registered to weather tower.";
        Simulation.towerLog(msg, p_flyable);
        observers.add(p_flyable);
    }

    public void unregister(Flyable p_flyable){
        Simulation.landingLog(p_flyable);
        observers.remove(p_flyable);
    }

    protected void conditionChanged(){
        for (Flyable observer : observers) {
            observer.updateConditions();
        }
    }
}