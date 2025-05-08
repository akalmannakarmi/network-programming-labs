//  Write a program in java to get local machines IPV4 Address & resolve the hostname to  IP4 Address. 
import java.net.*;

public class Q1 {
    public static void main(String[] args) {
        try {
            // Get local machine's IPv4 address
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("Local Machine Hostname: " + localHost.getHostName());
            System.out.println("Local Machine IPv4 Address: " + getIPv4Address(localHost));

            // Resolve hostname to IPv4 address
            String hostname = "www.google.com";  // Change this to any hostname you want to resolve
            InetAddress remoteHost = InetAddress.getByName(hostname);
            System.out.println("\nHostname: " + hostname);
            System.out.println("Resolved IPv4 Address: " + getIPv4Address(remoteHost));

        } catch (UnknownHostException e) {
            System.err.println("Error retrieving IP address: " + e.getMessage());
        }
    }

    // Helper method to filter out only IPv4 addresses
    private static String getIPv4Address(InetAddress inetAddress) {
        if (inetAddress.getHostAddress().contains(".")) {
            return inetAddress.getHostAddress();
        } else {
            return "No IPv4 Address Found";
        }
    }
}
