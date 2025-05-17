import java.io.*;
import java.net.*;

public class Q3 {
    public static void main(String[] args) {
        try {
            String baseUrl = "https://httpbin.org/get";
            String param1 = URLEncoder.encode("Academia", "UTF-8");
            String param2 = URLEncoder.encode("Nepal", "UTF-8");
            String fullUrl = baseUrl + "?college=" + param1 + "&country=" + param2;

            URL url = new URI(fullUrl).toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "JavaClient");

            BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream())
            );
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine).append("\n");
            }
            in.close();

            System.out.println("Response Code: " + connection.getResponseCode());
            System.out.println("Response Body:\n" + response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
