package rescue;

public class Location {
    private final String description;
    private final Area area;
    private final LocationType type;

    public Location(String description, Area area, LocationType type) throws IllegalArgumentException {
        if (description == null) {
            throw new IllegalArgumentException("description cannot be null");
        }
        String trimmedDescription = description.trim();
        if (trimmedDescription.isEmpty()) {
            throw new IllegalArgumentException("description cannot be empty");

        }
        if (trimmedDescription.contains(",")) {
            throw new IllegalArgumentException("description cannot contain comma");
        }
        if (trimmedDescription.contains(";")) {
            throw new IllegalArgumentException("description cannot contain semicolon");
        }
        if (area == null) {
            throw new IllegalArgumentException("area cannot be null");
        }
        if (type == null) {
            throw new IllegalArgumentException("type cannot be null");
        }
        this.description = description;
        this.area = area;
        this.type = type;
    }
    public String getDescription() {
        return description;
    }
    public Area getArea() {
        return area;
    }
    public LocationType getType() {
        return type;
    }
}
