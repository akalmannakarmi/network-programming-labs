import java.net.*;

public class Q1Client {
    public static void main(String[] args) {
        String serverMessage = "Hello, UDP Server";
        byte[] sendBuffer = serverMessage.getBytes();
        byte[] receiveBuffer = new byte[1024];

        try (DatagramSocket clientSocket = new DatagramSocket()) {
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 9876;

            // Send packet to server
            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress, serverPort);
            clientSocket.send(sendPacket);
            System.out.println("Message sent to server: " + serverMessage);

            // Receive response from server
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            clientSocket.receive(receivePacket);

            String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Response from server: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
