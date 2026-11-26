package rescue;

public class Bird extends Animal {
    public Bird(String species) {
        super(species);
    }

    @Override
    public AnimalType getType() {
        return AnimalType.BIRD;
    }
    @Override
    public int getRiskPoints() {
        return 0;
    }
    @Override
    public String getHandlingAdvice() {
        String bird = getSpecies().isEmpty() ? "bird"  : getSpecies();
        return "Cover the" + bird + "with a light cloth and place it in a ventilated box. Keep it quiet and avoid handling it";
    }
}
