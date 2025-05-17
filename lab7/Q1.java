// Configure the client socket options in java for the server localhost & port 3306.
// • setSoTimeout(int timeoutMillis)
// • setTcpNoDelay(boolean on)
// • setReceiveBufferSize(int size)
// • setSendBufferSize(int size)
// • setKeepAlive(boolean on)


import java.io.IOException;
import java.net.Socket;

public class Q1 {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int port = 13306;

        try (Socket socket = new Socket(serverAddress, port)) {
            socket.setSoTimeout(5000);
            socket.setTcpNoDelay(true);
            socket.setReceiveBufferSize(8192);
            socket.setSendBufferSize(8192);
            socket.setKeepAlive(true);

            System.out.println("Connected to " + serverAddress + ":" + port);
            System.out.println("SoTimeout: " + socket.getSoTimeout());
            System.out.println("TCP NoDelay: " + socket.getTcpNoDelay());
            System.out.println("Receive Buffer Size: " + socket.getReceiveBufferSize());
            System.out.println("Send Buffer Size: " + socket.getSendBufferSize());
            System.out.println("KeepAlive: " + socket.getKeepAlive());
        } catch (IOException e) {
            System.err.println("Error connecting to server: " + e.getMessage());
        }
    }
}
