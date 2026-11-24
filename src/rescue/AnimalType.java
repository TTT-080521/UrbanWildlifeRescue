package rescue;

public enum AnimalType {
    BIRD,
    REPTILE,
    MAMMAL;

    public static AnimalType fromText(String text) throws InvalidAnimalTypeException {
        if (text == null) {
            throw new InvalidAnimalTypeException(
                    "Animal type is missing from the row.");
        }
        String cleaned = text.trim().replace(' ', '_').toUpperCase();
        if (cleaned.isEmpty()) {
            throw new InvalidAnimalTypeException(
                    "Animal type is blank.");
        }
        for (AnimalType type : values()) {
            if (type.name().equals(cleaned)) {
                return type;
            }
        }
        throw new InvalidAnimalTypeException(
                "Unknown animal type \"" + text + "\". Allowed: BIRD, REPTILE, MAMMAL.");
    }
}