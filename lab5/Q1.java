
// Client
public class Q1 {
    public static void main(String[] args) {
        Server proxy = new ProxyServer();

        proxy.connect("192.168.0.5");
        proxy.connect("192.168.0.10");
        proxy.connect("10.0.0.1");
        proxy.connect("10.0.0.99");
    }
}

interface Server {
    void connect(String ipAddress);
}

class RealServer implements Server {
    @Override
    public void connect(String ipAddress) {
        System.out.println("Connected to the server from IP: " + ipAddress);
    }
}

class ProxyServer implements Server {
    private RealServer realServer = new RealServer();
    private static final String[] bannedIPs = {"192.168.0.10", "10.0.0.99"};

    private boolean isBanned(String ipAddress) {
        for (String banned : bannedIPs) {
            if (banned.equals(ipAddress)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void connect(String ipAddress) {
        if (isBanned(ipAddress)) {
            System.out.println("Access denied for IP: " + ipAddress);
        } else {
            realServer.connect(ipAddress);
        }
    }
}