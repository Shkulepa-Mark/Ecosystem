import java.util.ArrayList;
import java.util.List;

public class EcosystemSimulator {
    private List<Animal> animals;
    private List<Plant> plants;
    private Enviroment enviroment;

    public EcosystemSimulator() {
        animals = new ArrayList<>();
        plants = new ArrayList<>();
        enviroment = new Enviroment();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void addPlant(Plant plant) {
        plants.add(plant);
    }

    public void simulate() {
        for (Animal animal : animals) {
            animal.eat();
            animal.increaseAgeOneYear();
        }

        for (Plant plant : plants) {
            plant.grow();
        }

        System.out.println("Simulation completed");
    }

    public static void main(String[] args) {
        EcosystemSimulator ecosystemSimulator = new EcosystemSimulator();
    }
}
