import java.io.*;
import java.util.List;

public class FileManager {
    public void create(String filename, String data) {
        saveToFile(filename, data);
    }
    public String read(String filename) {
        return  readFromFile(filename);
    }

    public void update(String filename, String data) {
        delete(filename);
        saveToFile(filename, data);
    }

    public void delete(String filename) {
        File file = new File("resourses/" + filename);

        if (file.exists()) {
            if (file.delete()) {
                System.out.println("File " + filename + " deleted");
            } else {
                System.err.println("Error deleting file " + filename);
            }
        } else {
            System.err.println("File " + filename + "doesn't exist");
        }
    }

    public void saveSimulation(String filename, List<Animal> animals, List<Plant> plants) {
        StringBuilder data = new StringBuilder();
        for (Animal animal : animals) {
            data.append(animal.toString()).append("\n");
        }
        for (Plant plant : plants) {
            data.append(plant.toString()).append("\n");
        }
        saveToFile(filename, data.toString());
    }

    public void saveToFile(String filename, String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("resourses/" + filename))) {
            writer.write(data);

            System.out.println("Data successfully written to file");
        } catch (IOException e) {
            System.err.println("Error writing to file " + e.getMessage());
            e.printStackTrace();
        }
    }

    public String readFromFile(String filename) {
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader("resourses/" + filename))) {
            String line;

            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

            System.out.println("Data successfully read from file");
        } catch (IOException e) {
            System.err.println("Error reading from file " + e.getMessage());
            e.printStackTrace();
        }

        return content.toString();
    }
}
