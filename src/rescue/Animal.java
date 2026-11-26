package rescue;

public abstract class Animal {

    private final String species;

    protected Animal(String species) {
        this.species = species == null ? "" : species.trim();
    }

    public String getSpecies() {
        return species;
    }

    public abstract AnimalType getType();

    public abstract int getRiskPoints();

    public abstract String getHandlingAdvice();
}