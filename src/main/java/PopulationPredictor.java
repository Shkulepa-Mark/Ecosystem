import java.util.List;

public class PopulationPredictor {
    public String populationChange(Enviroment enviroment, List<Animal> animals, List<Plant> plants) {
        int temperature = enviroment.getTemperature();
        int waterSupply = enviroment.getWaterSupply();
        StringBuilder report = new StringBuilder();

        for (Animal animal : animals) {
            if (temperature < 10) {
                animal.decreaseHealth(10);
                report.append(animal.getSpecies()).append(" population decreased due to cold\n");
            } else if (temperature > 35) {
                animal.decreaseHealth(15);
                report.append(animal.getSpecies()).append(" population has decreased due to the heat\n");
            }

            if (animal.getHungerLevel() > 50) {
                animal.decreaseHealth(5);
                report.append(animal.getSpecies()).append(" suffering from hunger\n");
            }

            if (waterSupply < 30) {
                animal.decreaseHealth(5);
                report.append(animal.getSpecies()).append(" suffering from lack of water\n");
            }
        }

        for (Plant plant : plants) {
            if (temperature < 15) {
                plant.increaseWaterNeed(5);
                report.append(plant.getSpecies()).append(" requires more water due to cold\n");
            } else if (temperature > 30) {
                plant.increaseWaterNeed(30);
                report.append(plant.getSpecies()).append(" requires more water due to heat\n");
            }

            if (waterSupply < plant.getWaterNeed()) {
                plant.setHeight(plant.getHeight() - 1);
                report.append(plant.getSpecies()).append(" suffering from lack of water\n");
            }
        }

        return report.toString();
    }
}
