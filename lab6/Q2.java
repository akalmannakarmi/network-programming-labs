import java.net.*;
import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        try {
            URL url = new URI("https://www.academiacollege.edu.np/").toURL();
            
            URLConnection connection = url.openConnection();
            connection.connect();

            Map<String, List<String>> headers = connection.getHeaderFields();
            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                String headerName = entry.getKey();
                List<String> headerValues = entry.getValue();

                if (headerName != null) {
                    System.out.print(headerName + ": ");
                } else {
                    System.out.print("Status: ");
                }
                System.out.println(String.join(", ", headerValues));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
