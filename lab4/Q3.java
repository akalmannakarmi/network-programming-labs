// WAP in java to encode the string name=Ganesh Bhatta&age=33 
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Q3 {
    public static void main(String[] args) {
        try {
            String rawData = "name=Ganesh Bhatta&age=33";

            String encodedData = URLEncoder.encode(rawData, StandardCharsets.UTF_8.toString());

            System.out.println("Encoded String: " + encodedData);
            
        } catch (Exception e) {
            System.err.println("Encoding Error: " + e.getMessage());
        }
    }
}
