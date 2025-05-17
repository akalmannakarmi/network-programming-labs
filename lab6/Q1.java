import java.io.*;
import java.net.*;

public class Q1 {
    public static void main(String[] args) {
        try {
            URL url = new URI("https://www.academiacollege.edu.np/").toURL();
            URLConnection connection = url.openConnection();

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            
            int line = 0;
            String inputLine;
            while ((inputLine = in.readLine()) != null && line < 10) {
                System.out.println(inputLine);
                line+=1;
            }

            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
