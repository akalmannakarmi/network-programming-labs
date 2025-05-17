import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class RMIServer {
    public static void main(String[] args) {
        try {
            // Start the registry on port 1099
            LocateRegistry.createRegistry(10099);

            // Create and bind the remote object
            AdditionImpl obj = new AdditionImpl();
            Naming.rebind("AdditionService", obj);

            System.out.println("RMI Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
