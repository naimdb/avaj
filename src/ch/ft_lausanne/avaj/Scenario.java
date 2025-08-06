package ch.ft_lausanne.avaj;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ch.ft_lausanne.avaj.aircraft.AircraftFactory;
import ch.ft_lausanne.avaj.aircraft.Flyable;
import ch.ft_lausanne.avaj.tower.WeatherTower;
import ch.ft_lausanne.avaj.exceptions.*;

public class Scenario {

    private static final List<Flyable> observers = new ArrayList<>();
    private static Long nbLog;
    private static WeatherTower weatherTower = new WeatherTower();

    public static void readScenario(String fileName) throws AvajException {
        try (Simulation sim = new Simulation("simulation.txt", false)) {
            
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line = reader.readLine();
                if (line != null) {
                    nbLog = parseSimulationCount(line);
                } else {
                    throw new ScenarioException("Le fichier de scénario est vide");
                }

                observers.clear();
                long index = 1L;
                int lineNumber = 2;
                
                while ((line = reader.readLine()) != null) {
                    try {
                        String[] parts = validateAndSplitLine(line, lineNumber);
                        Flyable aircraft = processScenarioLine(parts, index, lineNumber);
                        observers.add(aircraft);
                        weatherTower.register(aircraft);
                        index++;
                        lineNumber++;
                    } catch (AvajException e) {
                        throw new ScenarioException(String.format("Ligne %d: %s", lineNumber, e.getMessage()), e);
                    }
                }
                
            } catch (FileNotFoundException e) {
                throw new ScenarioFileNotFoundException(fileName);
            } catch (IOException e) {
                throw new FileException("Erreur lors de la lecture du fichier de scénario: " + fileName, e);
            }
            
            if (observers.isEmpty()) {
                throw new ScenarioException("Aucun observateur n'a été ajouté au scénario");
            }

            Run.runSimulator(nbLog, weatherTower);
            
        } catch (Exception e) {
            throw new LogFileException("Impossible d'initialiser le fichier de simulation", e);
        }
    }

    private static Long parseSimulationCount(String line) throws InvalidCycleCountException {
        try {
            String trimmedLine = line.trim();
            if (trimmedLine.isEmpty()) {
                throw new InvalidCycleCountException("ligne vide");
            }
            
            Long result = Long.parseLong(trimmedLine);
            if (result <= 0) {
                throw new InvalidCycleCountException(trimmedLine);
            }
            return result;
        } catch (NumberFormatException e) {
            throw new InvalidCycleCountException(line.trim());
        }
    }

    private static String[] validateAndSplitLine(String line, int lineNumber) throws InvalidScenarioFormatException {
        if (line.trim().isEmpty()) {
            throw new InvalidScenarioFormatException(String.format("Ligne %d est vide", lineNumber));
        }
        
        String[] parts = line.trim().split("\\s+");
        if (parts.length != 5) {
            throw new InvalidScenarioFormatException(
                String.format("Ligne %d: attendu 5 éléments (TYPE NAME LONGITUDE LATITUDE HEIGHT), trouvé %d", 
                lineNumber, parts.length)
            );
        }
        return parts;
    }

    private static Flyable processScenarioLine(String[] parts, Long index, int lineNumber) throws AvajException {
        try {
            String type = Verify.verifyType(parts[0]);
            String name = type + "#" + Verify.verifyName(parts[1]);
            
            int longitude, latitude, height;
            
            try {
                longitude = Integer.parseInt(parts[2]);
                latitude = Integer.parseInt(parts[3]);
                height = Integer.parseInt(parts[4]);
            } catch (NumberFormatException e) {
                throw new InvalidScenarioFormatException(
                    String.format("Coordonnées invalides - longitude: '%s', latitude: '%s', hauteur: '%s'", 
                    parts[2], parts[3], parts[4])
                );
            }
            
            longitude = Verify.verifyLongitude(longitude);
            latitude = Verify.verifyLatitude(latitude);
            height = Verify.verifyHeight(height);
            
            Coordinates coordinates = new Coordinates(longitude, latitude, height);
            Flyable aircraft = AircraftFactory.getInstance().newAircraft(type, name, coordinates);
            
            if (aircraft == null) {
                throw new AircraftException("Impossible de créer l'aéronef");
            }
            
            return aircraft;
            
        } catch (UnknownAircraftTypeException | InvalidAircraftNameException | 
                 InvalidLongitudeException | InvalidLatitudeException | 
                 InvalidHeightException e) {
            throw e;
        } catch (Exception e) {
            throw new AircraftException("Erreur inattendue lors de la création de l'aéronef", e);
        }
    }
}