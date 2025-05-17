import java.io.*;

public class Q2 {
    public static void main(String[] args) {
        String filePath = "testout.txt"; // Make sure this file exists in the project directory or provide full path

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            System.out.println("Contents of " + filePath + ":");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
