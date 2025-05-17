import java.io.IOException;
import java.net.*;

public class Q2 {
    public static void main(String[] args) {
        try {
            Socket tcpSocket = new Socket();
            tcpSocket.setReuseAddress(true);
            tcpSocket.setSoTimeout(5000);
            tcpSocket.setReceiveBufferSize(8192);
            tcpSocket.setSendBufferSize(8192);
            tcpSocket.setTrafficClass(0x10);

            System.out.println("=== TCP Socket Options ===");
            System.out.println("SO_TIMEOUT      : " + tcpSocket.getSoTimeout());
            System.out.println("SO_RCVBUF       : " + tcpSocket.getReceiveBufferSize());
            System.out.println("SO_SNDBUF       : " + tcpSocket.getSendBufferSize());
            System.out.println("SO_REUSEADDR    : " + tcpSocket.getReuseAddress());
            System.out.println("IP_TOS (QoS)    : " + tcpSocket.getTrafficClass());

            tcpSocket.close();

            DatagramSocket udpSocket = new DatagramSocket(null);
            udpSocket.setReuseAddress(true);
            udpSocket.setBroadcast(true);
            udpSocket.setSoTimeout(3000);
            udpSocket.setReceiveBufferSize(4096);
            udpSocket.setSendBufferSize(4096);

            udpSocket.bind(new InetSocketAddress(9876));

            System.out.println("\n=== UDP Socket Options ===");
            System.out.println("SO_TIMEOUT      : " + udpSocket.getSoTimeout());
            System.out.println("SO_RCVBUF       : " + udpSocket.getReceiveBufferSize());
            System.out.println("SO_SNDBUF       : " + udpSocket.getSendBufferSize());
            System.out.println("SO_REUSEADDR    : " + udpSocket.getReuseAddress());
            System.out.println("SO_BROADCAST    : " + udpSocket.getBroadcast());

            udpSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
