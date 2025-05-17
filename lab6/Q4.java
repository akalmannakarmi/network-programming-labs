import java.net.*;

public class Q4 {
    public static void main(String[] args) {
        try {
            URL url = new URI("https://www.academiacollege.edu.np/").toURL();
            
            URLConnection connection = url.openConnection();
            connection.connect();

            String mimeType = connection.getContentType();
            System.out.println("MIME Type: " + mimeType);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
