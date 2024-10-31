import java.io.*;

public class FileManager {
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
