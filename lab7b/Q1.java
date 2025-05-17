import java.io.*;
import java.net.*;

public class Q1 {
    public static void main(String[] args) {
        int port = 5000;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            Socket clientSocket = serverSocket.accept();

            InetAddress clientAddress = clientSocket.getInetAddress();
            int clientPort = clientSocket.getPort();

            System.out.println("Client connected.");
            System.out.println("Client IP Address: " + clientAddress.getHostAddress());
            System.out.println("Client Hostname: " + clientAddress.getHostName());
            System.out.println("Client Port: " + clientPort);

            clientSocket.close();
        } catch (IOException e) {
            System.out.println("Server exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
