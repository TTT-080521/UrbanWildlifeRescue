package rescue;

public enum Area {
    NORTH,
    SOUTH,
    EAST,
    WEST,
    CENTRAL;

    public static Area fromText(String text) throws InvalidIncidentException {
        if (text == null) {
            throw new MissingLocationException(
                    "Area is missing from the row.");
        }
        String cleaned = text.trim().replace(' ', '_').toUpperCase();
        if (cleaned.isEmpty()) {
            throw new MissingLocationException(
                    "Area is blank.");
        }
        for (Area area : values()) {
            if (area.name().equals(cleaned)) {
                return area;
            }
        }
        throw new InvalidIncidentException(
                "Unknown area \"" + text + "\". Allowed: NORTH, SOUTH, EAST, WEST, CENTRAL.");
    }
}