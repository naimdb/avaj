package ch.ft_lausanne.avaj;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ch.ft_lausanne.avaj.aircraft.AircraftFactory;
import ch.ft_lausanne.avaj.aircraft.Flyable;
import ch.ft_lausanne.avaj.tower.WeatherTower;

public class Scenario {

    private static final List<Flyable> observers = new ArrayList<>();
    private static Long nbLog;

    public static void readScenario(String fileName) throws SimulationException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            if (line != null) {
                nbLog = numberOne(line);
            } else {
                throw new SimulationException("Le fichier de scénario est vide");
            }

            observers.clear();
            long index = 1L;
            while ((line = reader.readLine()) != null) {
                String[] parts = splitLine(line);
                observers.add(processScenarioLine(parts, index));
                index++;
            }
        } catch (IOException e) {
            throw new SimulationException("Erreur lors de la lecture du scénario", e);
        } catch (Exception e) {
            throw new SimulationException("Erreur inattendue lors de la lecture du scénario", e);
        }
		
        if (observers.isEmpty()) {
            throw new SimulationException("Aucun observateur n'a été ajouté au scénario");
        }

		try (Simulation sim = new Simulation("simulation.txt", true)) {
    Run.runSimulator(nbLog, observers);
} catch (IOException e) {
    throw new SimulationException("Erreur lors de l'initialisation du fichier de log", e);
}

    }

    private static Long numberOne(String line) throws SimulationException {
		try {
			Long res = Long.parseLong(line.trim());
			if (res <= 0) {
				throw new SimulationException("Erreur lors de la lecture du scénario");
			}
			return res;
		} catch (NumberFormatException e) {
			throw new SimulationException("Erreur lors de la lecture du scénario: Le nombre pour déterminer le nombre de ligne est invalide", e);
		}
    }

	private static String[] splitLine(String line) throws SimulationException {
		String[] parts = line.trim().split("\\s+");
		if (parts.length != 5) {
			throw new SimulationException("Erreur lors de la lecture du scénario: La ligne ne contient pas 5 éléments pour en déterminer le type, le nom, la longitude, la latitude et la hauteur");
		}
		return parts;
	}


    private static Flyable processScenarioLine(String[] parts, Long index) throws SimulationException  {
        try {
			String type = Verify.verifyType(parts[0]);
			String name = type + "#" + Verify.verifyName(parts[1]) + "(" + index + ")";
			int longitude = Verify.verifyLongitude(Integer.parseInt(parts[2]));
			int latitude = Verify.verifyLatitude(Integer.parseInt(parts[3]));
			int height = Verify.verifyHeight(Integer.parseInt(parts[4]));
			
			Coordinates coordinates = new Coordinates(longitude, latitude, height);
			Flyable aircraft = AircraftFactory.getInstance().newAircraft(type, name, coordinates);
			
			if (aircraft != null) {
				WeatherTower.register(aircraft);
			} else {
				throw new SimulationException("Erreur lors de la lecture du scénario: Le type d'aéronef est inconnu");
			}
			return aircraft;
		} catch (Exception e) {
			throw new SimulationException("Erreur lors de la lecture du scénario: " + e.getMessage(), e);
		}
    }
}
