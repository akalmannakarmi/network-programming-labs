import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastClient {
    public static void main(String[] args) {
        String multicastAddress = "230.0.0.0";
        int port = 4446;

        try (MulticastSocket socket = new MulticastSocket(port)) {
            InetAddress group = InetAddress.getByName(multicastAddress);
            socket.joinGroup(group);

            System.out.println("Joined multicast group. Waiting for messages...");

            byte[] buffer = new byte[1024];

            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                String received = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received: " + received);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
