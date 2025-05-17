import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            System.out.println("Server started. Waiting for client...");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader serverInput = new BufferedReader(new InputStreamReader(System.in));

            // Thread to read messages from client
            new Thread(() -> {
                String clientMsg;
                try {
                    while ((clientMsg = in.readLine()) != null) {
                        System.out.println("Client: " + clientMsg);
                    }
                } catch (IOException e) {
                    System.out.println("Client disconnected.");
                }
            }).start();

            // Sending messages to client
            String serverMsg;
            while ((serverMsg = serverInput.readLine()) != null) {
                out.println(serverMsg);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
