import java.util.List;

public class PopulationPredictor {
    public void predictAnimalChange(Enviroment enviroment, List<Animal> animals) {
        int temperature = enviroment.getTemperature();

        for (Animal animal : animals) {
            if (temperature > 35) {
                animal.decreaseHealth(5);
            }
        }
    }

    public void predictPlantChange(Enviroment enviroment, List<Plant> plants) {
        int humidity = enviroment.getHumidity();

        for (Plant plant : plants) {
            if (humidity < 30) {
                plant.increaseWaterNeed(10);
            }
        }
    }
}
