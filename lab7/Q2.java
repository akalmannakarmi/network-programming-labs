// Create a client to send an HTTP GET request to academiacollege.com and display the
// response using client socket.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Q2 {
    public static void main(String[] args) {
        String host = "academiacollege.com";
        int port = 80; // HTTP default port

        try (Socket socket = new Socket(host, port)) {
            // Output stream to send request
            PrintWriter writer = new PrintWriter(
                new OutputStreamWriter(socket.getOutputStream()), true);

            // Send HTTP GET request
            writer.println("GET / HTTP/1.1");
            writer.println("Host: " + host);
            writer.println("Connection: close");
            writer.println(); // Empty line to indicate end of headers

            // Input stream to read response
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

            // Read and print the response
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
