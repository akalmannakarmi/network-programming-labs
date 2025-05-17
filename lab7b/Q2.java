import java.io.IOException;
import java.net.*;

public class Q2 {
    public static void main(String[] args) {
        String ipAddress = "127.0.0.1";
        int port = 65432;

        try {
            InetAddress localAddr = InetAddress.getByName(ipAddress);
            ServerSocket serverSocket = new ServerSocket();
            
            serverSocket.setReuseAddress(true);

            serverSocket.bind(new InetSocketAddress(localAddr, port));

            System.out.println("Server Socket Information:");
            System.out.println("---------------------------");
            System.out.println("Local Address     : " + serverSocket.getInetAddress().getHostAddress());
            System.out.println("Local Port        : " + serverSocket.getLocalPort());
            System.out.println("SO_REUSEADDR      : " + serverSocket.getReuseAddress());
            System.out.println("Receive Buffer Size: " + serverSocket.getReceiveBufferSize() + " bytes");

            System.out.println("\nServer is running... Press Ctrl+C to stop.");
            serverSocket.accept();
            serverSocket.close();
        } catch (IOException e) {
            System.out.println("Exception occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
