package ch.ft_lausanne.avaj;

import static ch.ft_lausanne.avaj.Scenario.readScenario;

public class Simulator {

    public static Integer nbLog;

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("usage: un seul arguement");
            System.exit(1);
        }

        String scenarioFile = args[0];
        try {
            readScenario(scenarioFile);
		} catch (SimulationException e) {
			System.err.println(e.getMessage());
		} catch (Exception e) {
            System.err.println("Erreur");
        }
    }

}