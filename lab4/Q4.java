// WAP in java to decode the encoded string in Qno. c

import java.net.*;
import java.nio.charset.StandardCharsets;

public class Q4 {
    public static void main(String[] args) {
        try {
            // Encoded string from the previous example
            String encodedData = "name%3DGanesh+Bhatta%26age%3D33";

            // Decode the string using UTF-8
            String decodedData = URLDecoder.decode(encodedData, StandardCharsets.UTF_8.toString());

            // Print the decoded string
            System.out.println("Decoded String: " + decodedData);

        } catch (Exception e) {
            System.err.println("Decoding Error: " + e.getMessage());
        }
    }
}
