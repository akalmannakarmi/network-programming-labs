import java.io.IOException;
import java.net.*;

public class Q2 {
    public static void main(String[] args) {
        String ipAddress = "127.0.0.1";
        int port = 65432;

        try {
            // Bind server socket to specific IP and port
            InetAddress localAddr = InetAddress.getByName(ipAddress);
            ServerSocket serverSocket = new ServerSocket();
            
            // Optional: Enable address reuse before binding
            serverSocket.setReuseAddress(true);

            // Bind the socket to the IP and port
            serverSocket.bind(new InetSocketAddress(localAddr, port));

            // Display server socket information
            System.out.println("Server Socket Information:");
            System.out.println("---------------------------");
            System.out.println("Local Address     : " + serverSocket.getInetAddress().getHostAddress());
            System.out.println("Local Port        : " + serverSocket.getLocalPort());
            System.out.println("SO_REUSEADDR      : " + serverSocket.getReuseAddress());
            System.out.println("Receive Buffer Size: " + serverSocket.getReceiveBufferSize() + " bytes");

            // Keep the server open to accept connections (or comment this if not needed)
            System.out.println("\nServer is running... Press Ctrl+C to stop.");
            serverSocket.accept(); // Wait for a connection (optional)

            // Close socket after use (if accept is not used)
            // serverSocket.close();

        } catch (IOException e) {
            System.out.println("Exception occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
