package ch.ft_lausanne.avaj;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import ch.ft_lausanne.avaj.aircraft.Flyable;

public class Simulation {
    private static String fileName;
    private static boolean appendToFile;

    public Simulation(String fileName, boolean appendToFile) {
        Simulation.fileName = fileName;
        Simulation.appendToFile = appendToFile;
    }

    public static void towerLog(String message, Flyable one) {
        String msg = String.format("Tower says: %s(%s) %s", one.getName(), one.getId(), message);
        log(msg);
    }

    public static void flyableLog(String message, Flyable one) {
        String msg = String.format("%s(%s): %s", one.getName(), one.getId(), message);
        log(msg);
    }

    public static void registerLog(Flyable one) {
        String msg = String.format("%s(%s) registered to weather tower.", one.getName(), one.getId());
        log(msg);
    }

    public static void landingLog(Flyable one) {
        String msg = String.format("%s(%s) landing.", one.getName(), one.getId());
        log(msg);
    }

    private static void log(String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, appendToFile))) {
            writer.write(message);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            System.err.println("Erreur lors de l'écriture dans le fichier de log : " + e.getMessage());
        }
    }
}