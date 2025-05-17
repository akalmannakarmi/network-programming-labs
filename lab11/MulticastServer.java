import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastServer {
    public static void main(String[] args) {
        String multicastAddress = "230.0.0.0"; // Multicast group address
        int port = 4446; // Port to send data to

        try (MulticastSocket socket = new MulticastSocket()) {
            InetAddress group = InetAddress.getByName(multicastAddress);

            for (int i = 0; i < 5; i++) {
                String message = "Multicast message #" + i;
                byte[] buffer = message.getBytes();

                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, port);
                socket.send(packet);

                System.out.println("Sent: " + message);
                Thread.sleep(2000); // Delay between messages
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
