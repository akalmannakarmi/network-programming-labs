import java.io.*;
import java.nio.channels.*;
import java.nio.file.*;
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the full path of input file: ");
        String inputPathStr = scanner.nextLine();

        Path inputPath = Paths.get(inputPathStr);
        Path outputPath = inputPath.getParent().resolve("output.txt");

        try (
            FileChannel sourceChannel = FileChannel.open(inputPath, StandardOpenOption.READ);
            FileChannel destChannel = FileChannel.open(outputPath,
                StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING)
        ) {
            long size = sourceChannel.size();
            sourceChannel.transferTo(0, size, destChannel);

            System.out.println("File copied successfully to: " + outputPath.toString());

        } catch (IOException e) {
            System.out.println("Error during file copy: " + e.getMessage());
        }
    }
}
