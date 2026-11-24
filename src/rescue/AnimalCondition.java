package rescue;

public enum AnimalCondition {
    INJURED,
    TRAPPED,
    DISPLACED,
    ABANDONED;

    public static AnimalCondition fromText(String text) throws InvalidPriorityException {
        if (text == null) {
            throw new InvalidPriorityException(
                    "Condition is missing from the row.");
        }
        String cleaned = text.trim().replace(' ', '_').toUpperCase();
        if (cleaned.isEmpty()) {
            throw new InvalidPriorityException(
                    "Condition is blank.");
        }
        for (AnimalCondition condition : values()) {
            if (condition.name().equals(cleaned)) {
                return condition;
            }
        }
        throw new InvalidPriorityException(
                "Unknown condition \"" + text + "\". Allowed: INJURED, TRAPPED, DISPLACED, ABANDONED.");
    }
}