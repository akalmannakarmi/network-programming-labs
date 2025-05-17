import java.net.*;
import java.nio.*;
import java.nio.channels.*;

public class Q3Client {
    public static void main(String[] args) {
        int port = 9876;
        String message = "Hello, UDP Server";

        try (DatagramChannel clientChannel = DatagramChannel.open()) {
            clientChannel.bind(null);

            ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
            InetSocketAddress serverAddress = new InetSocketAddress("localhost", port);
            clientChannel.send(buffer, serverAddress);
            System.out.println("Message sent to server: " + message);

            buffer.clear();
            clientChannel.receive(buffer);
            buffer.flip();
            String response = new String(buffer.array(), 0, buffer.limit());
            System.out.println("Response from server: " + response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
