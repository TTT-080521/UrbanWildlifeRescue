package rescue;

public class Reptile extends Animal{

    public Reptile(String species) {
        super(species);
    }

    @Override
    public AnimalType getType() {
        return AnimalType.REPTILE;
    }

    @Override
    public int getRiskPoints() {
        return 10;
    }

    @Override
    public String getHandlingAdvice() {
        String animal = getSpecies().isEmpty() ? "reptile" : getSpecies();
        return "Lift the " + animal + " with a snake hook, never by hand.";
    }
}
