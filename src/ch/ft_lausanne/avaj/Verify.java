package ch.ft_lausanne.avaj;

import ch.ft_lausanne.avaj.exceptions.*;

public class Verify {

    static String verifyType(String type) throws UnknownAircraftTypeException {
        if (!type.matches("(Baloon|Helicopter|JetPlane)")) {
            throw new UnknownAircraftTypeException(type);
        }
        return type;
    }

    static String verifyName(String name) throws InvalidAircraftNameException {
        if (!name.matches("^[A-Z][a-z0-9]+$")) {
            throw new InvalidAircraftNameException(name);
        }
        return name;
    }

    static int verifyLongitude(int longitude) throws InvalidLongitudeException {
        if (longitude < 0) {
            throw new InvalidLongitudeException(longitude);
        }
        return longitude;
    }

    static int verifyLatitude(int latitude) throws InvalidLatitudeException {
        if (latitude < 0) {
            throw new InvalidLatitudeException(latitude);
        }
        return latitude;
    }

    static int verifyHeight(int height) throws InvalidHeightException {
        if (height < 0) {
            throw new InvalidHeightException(height);
        }
        if (height > 100) {
            return 100;
        }
        return height;
    }
}