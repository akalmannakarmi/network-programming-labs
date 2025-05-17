import java.net.*;
import java.nio.*;
import java.nio.channels.*;

public class Q3Server {
    public static void main(String[] args) {
        int port = 9876;

        try (DatagramChannel serverChannel = DatagramChannel.open()) {
            serverChannel.bind(new InetSocketAddress(port));
            System.out.println("UDP Server started on port " + port);

            ByteBuffer buffer = ByteBuffer.allocate(1024);

            // Receive data
            SocketAddress clientAddress = serverChannel.receive(buffer);
            buffer.flip();
            String received = new String(buffer.array(), 0, buffer.limit());
            System.out.println("Received from client: " + received);

            // Send response
            buffer.clear();
            String response = "Hello, UDP Client";
            buffer.put(response.getBytes());
            buffer.flip();
            serverChannel.send(buffer, clientAddress);
            System.out.println("Response sent to client.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
