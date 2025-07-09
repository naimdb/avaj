package ch.ft_lausanne.avaj;

public class Verify {

    static String verifyType(String type) throws Exception {
        if (!type.matches("(Baloon|Helicopter|JetPlane)")) {
            throw new SimulationException("Erreur lors de la lecture du scénario: Le type d'aéronef est inconnu");
        }
        return type;
    }
    static String verifyName(String name) throws Exception {
        if (!name.matches("^[A-Z][a-z0-9]+$")) {
            throw new SimulationException("Erreur lors de la lecture du scénario: Le nom de l'aéronef est invalide");
        }
        return name;
    }

    static int verifyLongitude(int l) throws Exception {
        if (l < 0) {
            throw new SimulationException("Erreur lors de la lecture du scénario: La longitude est invalide");
        }
        return l;
    }

    static int verifyLatitude(int l) throws Exception {
        if (l < 0) {
            throw new SimulationException("Erreur lors de la lecture du scénario: La latitude est invalide");
        }
        return l;
    }

	static int verifyHeight(int h) throws Exception {
		if (h < 0) {
			throw new SimulationException("Erreur lors de la lecture du scénario: La hauteur est invalide");
		}
		if (h > 100) {
			return 100;
		}
		return h;
	}
}
