import java.net.*;

public class Q1Server {
    public static void main(String[] args) {
        int port = 9876;
        byte[] receiveBuffer = new byte[1024];

        try (DatagramSocket serverSocket = new DatagramSocket(port)) {
            System.out.println("UDP Server is listening on port " + port);

            // Receive packet
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            serverSocket.receive(receivePacket);

            String clientMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Received from client: " + clientMessage);

            // Prepare response
            String response = "Hello, UDP Client";
            byte[] sendBuffer = response.getBytes();

            InetAddress clientAddress = receivePacket.getAddress();
            int clientPort = receivePacket.getPort();

            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, clientAddress, clientPort);
            serverSocket.send(sendPacket);

            System.out.println("Response sent to client.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
