package ch.ft_lausanne.avaj;

import static ch.ft_lausanne.avaj.Scenario.readScenario;
import ch.ft_lausanne.avaj.exceptions.*;

public class Simulator {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java Simulator <scenario_file>");
            System.err.println("Erreur: Exactement un argument requis (fichier de scénario)");
            System.exit(1);
        }

        String scenarioFile = args[0];
        
        try {
            readScenario(scenarioFile);
            System.out.println("Simulation terminée avec succès. Consultez simulation.txt pour les résultats.");
            
        } catch (ScenarioFileNotFoundException e) {
            System.err.println("❌ Fichier non trouvé: " + e.getMessage());
            System.exit(2);
            
        } catch (InvalidCycleCountException e) {
            System.err.println("❌ Erreur de format: " + e.getMessage());
            System.exit(3);
            
        } catch (InvalidScenarioFormatException e) {
            System.err.println("❌ Format de scénario invalide: " + e.getMessage());
            System.exit(4);
            
        } catch (UnknownAircraftTypeException e) {
            System.err.println("❌ Type d'aéronef invalide: " + e.getMessage());
            System.exit(5);
            
        } catch (InvalidAircraftNameException e) {
            System.err.println("❌ Nom d'aéronef invalide: " + e.getMessage());
            System.exit(6);
            
        } catch (CoordinateException e) {
            System.err.println("❌ Coordonnées invalides: " + e.getMessage());
            System.exit(7);
            
        } catch (AircraftException e) {
            System.err.println("❌ Erreur d'aéronef: " + e.getMessage());
            System.exit(8);
            
        } catch (LogFileException e) {
            System.err.println("❌ Erreur de fichier de log: " + e.getMessage());
            System.exit(9);
            
        } catch (FileException e) {
            System.err.println("❌ Erreur de fichier: " + e.getMessage());
            System.exit(10);
            
        } catch (ScenarioException e) {
            System.err.println("❌ Erreur de scénario: " + e.getMessage());
            if (e.getCause() != null) {
                System.err.println("   Cause: " + e.getCause().getMessage());
            }
            System.exit(11);
            
        } catch (AvajException e) {
            System.err.println("❌ Erreur générale: " + e.getMessage());
            System.exit(12);
            
        } catch (Exception e) {
            System.err.println("❌ Erreur inattendue: " + e.getMessage());
            e.printStackTrace();
            System.exit(99);
        }
    }
}