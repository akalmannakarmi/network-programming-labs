// Write a java program to implement the IPV6 Address.
import java.net.*;

public class Q2 {
    public static void main(String[] args) {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("Local Machine Hostname: " + localHost.getHostName());
            System.out.println("Local Machine IPv6 Address: " + getIPv6Address(localHost));

            String hostname = "www.google.com";
            InetAddress[] addresses = InetAddress.getAllByName(hostname);
            
            System.out.println("\nHostname: " + hostname);
            for (InetAddress address : addresses) {
                String ipv6 = getIPv6Address(address);
                if (!ipv6.equals("No IPv6 Address Found")) {
                    System.out.println("Resolved IPv6 Address: " + ipv6);
                }
            }

        } catch (UnknownHostException e) {
            System.err.println("Error retrieving IP address: " + e.getMessage());
        }
    }

    private static String getIPv6Address(InetAddress inetAddress) {
        if (inetAddress.getHostAddress().contains(":")) {
            return inetAddress.getHostAddress();
        } else {
            return "No IPv6 Address Found"; 
        }
    }
}
