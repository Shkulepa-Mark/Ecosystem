import java.util.ArrayList;
import java.util.List;

public class EcosystemSimulator {
    private List<Animal> animals;
    private List<Plant> plants;
    private Enviroment enviroment;
    private FileManager fileManager;

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
            animal.starve();
        }

        for (Plant plant : plants) {
            plant.grow();
        }

        enviroment.changeWeather();

        System.out.println("Simulation completed");
    }

    private void logSimulation() {
        String filename = "Ecosystem_Log.txt";
        StringBuilder logData = new StringBuilder();
        logData.append("Environment: Temperature = ").append(enviroment.getTemperature()).append(", Humidity = ").append(enviroment.getHumidity()).append("\n");

        for (Animal animal : animals) {
            logData.append(animal.toString()).append("\n");
        }

        for (Plant plant : plants) {
            logData.append(plant.toString()).append("\n");
        }

        fileManager.saveToFile(filename, logData.toString());
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public List<Plant> getPlants() {
        return plants;
    }
}
