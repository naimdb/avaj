package ch.ft_lausanne.avaj;

import java.util.List;
import ch.ft_lausanne.avaj.aircraft.Flyable;
import ch.ft_lausanne.avaj.tower.Tower;

public class Run {
    public static void runSimulator(Long nbLog, List<Flyable> observers) {
        int nbFlyable = observers.size();

        for (int i = 0; i <= nbLog && !observers.isEmpty(); i++) {
            Flyable currentFlyable = observers.get(i % observers.size());
            currentFlyable.updateConditions();
            
            if (currentFlyable.getCoordinate().getHeight() <= 0) {
                Tower.unregister(currentFlyable);
                observers.remove(currentFlyable);
                if (observers.isEmpty()) break;
            }
        }
    }
}