// WAP in java to encode the string name=Ganesh Bhatta&age=33 
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Q3 {
    public static void main(String[] args) {
        try {
            // Define the raw query string
            String rawData = "name=Ganesh Bhatta&age=33";

            // Encode the string using UTF-8
            String encodedData = URLEncoder.encode(rawData, StandardCharsets.UTF_8.toString());

            // Print the encoded string
            System.out.println("Encoded String: " + encodedData);
            
        } catch (Exception e) {
            System.err.println("Encoding Error: " + e.getMessage());
        }
    }
}
