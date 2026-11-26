package rescue;

public class Mammal extends Animal {

    public Mammal(String species) {
        super(species);
    }

    @Override
    public AnimalType getType(){
        return AnimalType.MAMMAL;
    }

    @Override
    public int getRiskPoints(){
        return 5;
    }

    @Override
    public String getHandlingAdvice() {
        String animal = getSpecies().isEmpty() ? "mammal" : getSpecies();
        return "Approach the " + animal + " slowly and quietly; "
                + "use a carrier and do not chase it.";
    }
}
