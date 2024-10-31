import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class EcosystemApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EcosystemSimulator ecosystemSimulator;
        FileManager fileManager = new FileManager();

        System.out.println("Enter 1 to create a new simulation, 2 to load an existing one:");
        int choice = scanner.nextInt();

        if (choice == 1) {
            ecosystemSimulator = new EcosystemSimulator();
            ecosystemSimulator.addAnimal(new Animal("Lion", 5, 80, 20));
            ecosystemSimulator.addPlant(new Plant("Oak", 10, 30));

            System.out.println("Enter a name for the new simulation:");
            String filename = scanner.next() + ".txt";

            fileManager.saveSimulation(filename, ecosystemSimulator.getAnimals(), ecosystemSimulator.getPlants());
            System.out.println("A new simulation is created and saved");
        } else if (choice == 2) {
            System.out.println("Enter name file:");
            String filename = scanner.next();
            String data = fileManager.read(filename);
            ecosystemSimulator = parseSimulationData(data);
            System.out.println("Simulation data:");
            System.out.println(data);
            System.out.println("The simulation is loaded");
        } else {
            System.out.println("Wrong choice!");
        }
    }

    private static EcosystemSimulator parseSimulationData(String data) {
        EcosystemSimulator simulator = new EcosystemSimulator();
        String[] lines = data.split("\n");

        for (String line : lines) {
            if (line.startsWith("ID:")) {
                String[] parts = line.split(", ");
                if (parts[1].startsWith("Species: ")) {
                    String species = parts[1].substring(9);
                    if (parts[2].contains("age")) {
                        // Animal
                        int age = Integer.parseInt(parts[2].split(" = ")[1]);
                        int health = Integer.parseInt(parts[3].split(" = ")[1]);
                        int hunger = Integer.parseInt(parts[4].split(" = ")[1].replace("]", ""));
                        simulator.addAnimal(new Animal(species, age, health, hunger));
                    } else if (parts[2].contains("height")) {
                        // Plant
                        int height = Integer.parseInt(parts[2].split(" = ")[1]);
                        int waterNeed = Integer.parseInt(parts[3].split(" = ")[1].replace("]", ""));
                        simulator.addPlant(new Plant(species, height, waterNeed));
                    }
                }
            }
        }

        return simulator;
    }
}