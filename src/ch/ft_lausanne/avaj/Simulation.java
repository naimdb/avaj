package ch.ft_lausanne.avaj;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import ch.ft_lausanne.avaj.aircraft.Flyable;

public class Simulation implements AutoCloseable {
    private static String fileName;
    private static BufferedWriter logWriter;

    public Simulation(String fileName, boolean appendToFile) {
        Simulation.fileName = fileName; 
        try {
            initLog(appendToFile); 
        } catch (IOException e) {
            System.err.println("Erreur initialisation log : " + e.getMessage());
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
        String msg = String.format("%s(%s) registered to weather tower.", one.getName(), one.getId());
        log(msg);
    }

    public static void landingLog(Flyable one) {
        String msg = String.format("%s(%s) landing.", one.getName(), one.getId());
        log(msg);
    }

    private static void log(String message) {
        try {
            if (logWriter != null) {
                logWriter.write(message);
                logWriter.write("test");
                logWriter.newLine();
                logWriter.flush();
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de l'écriture dans le fichier de log : " + e.getMessage());
        }
    }

    public static void closeLog() throws IOException {
        if (logWriter != null) {
            logWriter.close();
            logWriter = null;
        }
    }

	@Override
    public void close() throws IOException {
        closeLog();
    }
}