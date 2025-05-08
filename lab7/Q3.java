// Write a Java client that connects to a server at localhost:1234, sends "Hello, Server!",
// reads the response, and prints it.
import java.io.*;
import java.net.*;

public class Q3 {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 1234;

        try (Socket socket = new Socket(host, port)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Send message to server
            String message = "Hello, Server!";
            out.println(message);
            System.out.println("Sent: " + message);

            // Read response
            String response = in.readLine();
            System.out.println("Received: " + response);

        } catch (IOException e) {
            System.err.println("Client exception: " + e.getMessage());
        }
    }
}
