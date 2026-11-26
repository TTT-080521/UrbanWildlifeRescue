package rescue;

import java.time.LocalDateTime;
import java.util.EnumSet;
import java.util.Set;

public class RescueIncident {

    private final LocalDateTime reportedAt;
    private final Animal animal;
    private final AnimalCondition condition;
    private final int animalCount;
    private final boolean immediateDanger;
    private final Location location;
    private final Set<Equipment> requiredEquipment;
    private final ContactDetails reporter;

    private String incidentId;
    private int priorityScore;
    private PriorityLevel priorityLevel;
    private IncidentStatus status;
    private String outcome;

    public RescueIncident(LocalDateTime reportedAt, AnimalType animalType, String species,
                          AnimalCondition condition, int animalCount, boolean immediateDanger,
                          String locationDescription, Area area, LocationType locationType,
                          Set<Equipment> requiredEquipment,
                          String reporterName, String reporterPhone)
            throws InvalidIncidentException {
        if (reportedAt == null) {
            throw new InvalidIncidentException("Reported-at time is missing.");
        }
        if (animalType == null) {
            throw new InvalidIncidentException("Animal type is missing.");
        }
        if (condition == null) {
            throw new InvalidIncidentException("Condition is missing.");
        }
        if (animalCount < 1 || animalCount > 200) {
            throw new InvalidIncidentException(
                    "Number of animals must be 1-200 (got " + animalCount + ").");
        }
        if (species != null) {
            String trimmedSpecies = species.trim();
            if (trimmedSpecies.contains(",")) {
                throw new InvalidIncidentException(
                        "Species must not contain a comma (it would break the CSV row).");
            }
            if (trimmedSpecies.contains(";")) {
                throw new InvalidIncidentException("Species must not contain a semicolon.");
            }
        }

        this.reportedAt = reportedAt;
        this.animal = createAnimal(animalType, species);
        this.condition = condition;
        this.animalCount = animalCount;
        this.immediateDanger = immediateDanger;
        this.location = new Location(locationDescription, area, locationType);
        this.requiredEquipment = copyEquipment(requiredEquipment);
        this.reporter = new ContactDetails(reporterName, reporterPhone);

        this.incidentId = null;
        this.priorityScore = 0;
        this.priorityLevel = null;
        this.status = IncidentStatus.PENDING_ASSIGNMENT;
        this.outcome = null;
    }

    private Animal createAnimal(AnimalType type, String species) throws InvalidIncidentException {
        switch (type) {
            case BIRD:
                return new Bird(species);
            case REPTILE:
                return new Reptile(species);
            case MAMMAL:
                return new Mammal(species);
            default:
                throw new InvalidIncidentException("Unhandled animal type: " + type);
        }
    }

    private Set<Equipment> copyEquipment(Set<Equipment> source) {
        Set<Equipment> copy = EnumSet.noneOf(Equipment.class);
        if (source != null) {
            copy.addAll(source);
        }
        return copy;
    }
}