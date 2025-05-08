import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class Q3 {
    public static void main(String[] args) {
        try {
            // URL to send GET request to
            String url = "https://jsonplaceholder.typicode.com/posts/1"; // Example test API

            // Create a URL object
            URI uri = new URI(url);
            URL obj = uri.toURL();

            // Open connection
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // Set request method to GET
            con.setRequestMethod("GET");

            // Get response code
            int responseCode = con.getResponseCode();
            System.out.println("GET Response Code: " + responseCode);

            // If response is OK (200)
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read response
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Print response
                System.out.println("Response:");
                System.out.println(response.toString());
            } else {
                System.out.println("GET request failed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
