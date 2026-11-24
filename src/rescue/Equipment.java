package rescue;

public enum Equipment {
    ANIMAL_CARRIER,
    CATCH_NET,
    SNAKE_HOOK,
    LADDER,
    CLIMBING_HARNESS,
    WATER_RESCUE_KIT,
    CUTTING_TOOLS;

    public static Equipment fromText(String text) throws InvalidTeamException {
        if (text == null) {
            throw new InvalidTeamException(
                    "Equipment is missing from the row.");
        }
        String cleaned = text.trim().replace(' ', '_').toUpperCase();
        if (cleaned.isEmpty()) {
            throw new InvalidTeamException(
                    "Equipment is blank.");
        }
        for (Equipment equipment : values()) {
            if (equipment.name().equals(cleaned)) {
                return equipment;
            }
        }
        throw new InvalidTeamException(
                "Unknown equipment \"" + text + "\". Allowed: ANIMAL_CARRIER, CATCH_NET, "
                        + "SNAKE_HOOK, LADDER, CLIMBING_HARNESS, WATER_RESCUE_KIT, CUTTING_TOOLS.");
    }
}