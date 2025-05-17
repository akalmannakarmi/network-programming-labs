import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 5000;

        try (Socket socket = new Socket(hostname, port)) {
            System.out.println("Connected to server.");

            // Streams for communication
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

            // Thread to read from server
            Thread reader = new Thread(() -> {
                String message;
                try {
                    while ((message = input.readLine()) != null) {
                        System.out.println("Server: " + message);
                    }
                } catch (IOException e) {
                    System.out.println("Server disconnected.");
                }
            });

            reader.start();

            // Sending messages to server
            String clientMessage;
            while ((clientMessage = console.readLine()) != null) {
                output.println(clientMessage);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
