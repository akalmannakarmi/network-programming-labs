// Get detailed information about each network interface (e.g., MAC address, IP addresses). 

import java.net.*;
import java.util.Enumeration;

public class Q2 {
    public static void main(String[] args) {
        try {
            // Get all network interfaces on the system
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

            while (interfaces.hasMoreElements()) {
                NetworkInterface networkInterface = interfaces.nextElement();

                System.out.println("==================================================");
                System.out.println("Interface Name: " + networkInterface.getName());
                System.out.println("Display Name: " + networkInterface.getDisplayName());

                // Get and display MAC (hardware) address
                byte[] mac = networkInterface.getHardwareAddress();
                if (mac != null) {
                    System.out.print("MAC Address: ");
                    for (int i = 0; i < mac.length; i++) {
                        System.out.printf("%02X%s", mac[i], (i < mac.length - 1) ? "-" : "");
                    }
                    System.out.println();
                } else {
                    System.out.println("MAC Address: Not available");
                }

                // Display network properties
                System.out.println("MTU: " + networkInterface.getMTU());
                System.out.println("Is Up: " + networkInterface.isUp());
                System.out.println("Is Loopback: " + networkInterface.isLoopback());
                System.out.println("Is Virtual: " + networkInterface.isVirtual());
                System.out.println("Supports Multicast: " + networkInterface.supportsMulticast());

                // Get assigned IP addresses (IPv4 & IPv6)
                Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress address = addresses.nextElement();
                    System.out.println("IP Address: " + address.getHostAddress());
                }

                System.out.println("==================================================");
            }
        } catch (SocketException e) {
            System.err.println("Error retrieving network interfaces: " + e.getMessage());
        }
    }
}
