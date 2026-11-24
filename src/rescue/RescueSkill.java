package rescue;

public enum RescueSkill {
    CLIMBING,
    WATER_RESCUE,
    CONFINED_SPACE_RESCUE,
    TRAFFIC_CONTROL,
    ANIMAL_FIRST_AID;

    public static RescueSkill fromText(String text) throws InvalidTeamException {
        if (text == null) {
            throw new InvalidTeamException(
                    "Skill is missing from the row.");
        }
        String cleaned = text.trim().replace(' ', '_').toUpperCase();
        if (cleaned.isEmpty()) {
            throw new InvalidTeamException(
                    "Skill is blank.");
        }
        for (RescueSkill skill : values()) {
            if (skill.name().equals(cleaned)) {
                return skill;
            }
        }
        throw new InvalidTeamException(
                "Unknown skill \"" + text + "\". Allowed: CLIMBING, WATER_RESCUE, "
                        + "CONFINED_SPACE_RESCUE, TRAFFIC_CONTROL, ANIMAL_FIRST_AID.");
    }
}