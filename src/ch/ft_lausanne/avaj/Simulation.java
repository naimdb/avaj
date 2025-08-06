package ch.ft_lausanne.avaj;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import ch.ft_lausanne.avaj.aircraft.Flyable;
import ch.ft_lausanne.avaj.exceptions.LogFileException;

public class Simulation implements AutoCloseable {
    private static String fileName;
    private static BufferedWriter logWriter;

    public Simulation(String fileName, boolean appendToFile) throws LogFileException {
        Simulation.fileName = fileName; 
        try {
            initLog(appendToFile); 
        } catch (IOException e) {
            throw new LogFileException("Impossible d'initialiser le fichier de log: " + fileName, e);
        }
    }

    private static void initLog(boolean appendToFile) throws IOException {
        logWriter = new BufferedWriter(new FileWriter(fileName, appendToFile));
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
        String msg = String.format("Tower says: %s(%s) registered to weather tower.", one.getName(), one.getId());
        log(msg);
    }

    public static void landingLog(Flyable one) {
        String landingMsg = String.format("%s(%s) landing.", one.getName(), one.getId());
        log(landingMsg);
        
        String unregisterMsg = String.format("Tower says: %s(%s) unregistered from weather tower.", one.getName(), one.getId());
        log(unregisterMsg);
    }

    private static void log(String message) {
        try {
            if (logWriter != null) {
                logWriter.write(message);
                logWriter.newLine();
                logWriter.flush();
            }
        } catch (IOException e) {
            System.err.println("⚠️  Erreur lors de l'écriture dans le fichier de log: " + e.getMessage());
            System.err.println("   Message perdu: " + message);
        }
    }

    public static void closeLog() throws LogFileException {
        try {
            if (logWriter != null) {
                logWriter.close();
                logWriter = null;
            }
        } catch (IOException e) {
            throw new LogFileException("Impossible de fermer le fichier de log", e);
        }
    }

    @Override
    public void close() throws LogFileException {
        closeLog();
    }
}