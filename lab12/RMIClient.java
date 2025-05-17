import java.rmi.Naming;

public class RMIClient {
    public static void main(String[] args) {
        try {
            // Lookup the remote object
            Addition stub = (Addition) Naming.lookup("rmi://localhost/AdditionService");

            // Call remote method
            int result = stub.add(5, 3);
            System.out.println("Result from remote method: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
