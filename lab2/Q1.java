//  Write a program in java to get local machines IPV4 Address & resolve the hostname to  IP4 Address. 
import java.net.*;

public class Q1 {
    public static void main(String[] args) {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("Local Machine Hostname: " + localHost.getHostName());
            System.out.println("Local Machine IPv4 Address: " + localHost.getHostAddress());

            String hostname = "www.google.com";
            InetAddress remoteHost = InetAddress.getByName(hostname);
            System.out.println("\nHostname: " + hostname);
            System.out.println("Resolved IPv4 Address: " + remoteHost.getHostAddress());

        } catch (UnknownHostException e) {
            System.err.println("Error retrieving IP address: " + e.getMessage());
        }
    }
}
