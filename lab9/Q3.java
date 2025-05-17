import java.io.*;

public class Q3 {
    public static void main(String[] args) {
        String[] inputFiles = {"input1.txt", "input2.txt", "input3.txt", "input4.txt"};
        String outputFile = "combinedout.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (String inputFile : inputFiles) {
                try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        writer.write(line);
                        writer.newLine();
                    }
                    writer.newLine();
                } catch (FileNotFoundException e) {
                    System.out.println("File not found: " + inputFile);
                }
            }
            System.out.println("Files merged successfully into " + outputFile);
        } catch (IOException e) {
            System.out.println("Error writing to the output file: " + e.getMessage());
        }
    }
}
