// WAP in java to decode the encoded string in Qno. c

import java.net.*;
import java.nio.charset.StandardCharsets;

public class Q4 {
    public static void main(String[] args) {
        try {
            String encodedData = "name%3DGanesh+Bhatta%26age%3D33";

            String decodedData = URLDecoder.decode(encodedData, StandardCharsets.UTF_8.toString());

            System.out.println("Decoded String: " + decodedData);

        } catch (Exception e) {
            System.err.println("Decoding Error: " + e.getMessage());
        }
    }
}
