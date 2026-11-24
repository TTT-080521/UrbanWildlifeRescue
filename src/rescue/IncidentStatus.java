package rescue;

public enum IncidentStatus {
    PENDING_ASSIGNMENT,
    ASSIGNED,
    IN_PROGRESS,
    COMPLETED,
    CANCELLED;

    public static IncidentStatus fromText(String text) throws InvalidIncidentException {
        if (text == null) {
            throw new InvalidIncidentException(
                    "Status is missing from the row.");
        }
        String cleaned = text.trim().replace(' ', '_').toUpperCase();
        if (cleaned.isEmpty()) {
            throw new InvalidIncidentException(
                    "Status is blank.");
        }
        for (IncidentStatus status : values()) {
            if (status.name().equals(cleaned)) {
                return status;
            }
        }
        throw new InvalidIncidentException(
                "Unknown status \"" + text + "\". Allowed: PENDING_ASSIGNMENT, ASSIGNED, "
                        + "IN_PROGRESS, COMPLETED, CANCELLED.");
    }
}