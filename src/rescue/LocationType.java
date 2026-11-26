package rescue;

import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public enum LocationType {
    ROAD(RescueSkill.TRAFFIC_CONTROL),
    WATER(RescueSkill.WATER_RESCUE),
    HEIGHT(RescueSkill.CLIMBING),
    CONFINED_SPACE(RescueSkill.CONFINED_SPACE_RESCUE),
    BUILDING(),
    OPEN_GROUND();

    private final Set<RescueSkill> requiredSkills;

    private LocationType(RescueSkill... skills) {
        Set<RescueSkill> set = EnumSet.noneOf(RescueSkill.class);
        for (RescueSkill skill : skills) {
            set.add(skill);
        }
        this.requiredSkills = set;
    }

    public Set<RescueSkill> getRequiredSkills() {
        return Collections.unmodifiableSet(new HashSet<>(requiredSkills));
    }

    public static LocationType fromText(String text) throws InvalidPriorityException {
        if (text == null) {
            throw new InvalidPriorityException(
                    "Location type is missing from the row.");
        }
        String cleaned = text.trim().replace(' ', '_').toUpperCase();
        if (cleaned.isEmpty()) {
            throw new InvalidPriorityException(
                    "Location type is blank.");
        }
        for (LocationType type : values()) {
            if (type.name().equals(cleaned)) {
                return type;
            }
        }
        throw new InvalidPriorityException(
                "Unknown location type \"" + text + "\". Allowed: ROAD, WATER, HEIGHT, "
                        + "CONFINED_SPACE, BUILDING, OPEN_GROUND.");
    }
}