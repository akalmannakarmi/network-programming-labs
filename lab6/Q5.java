import java.io.*;
import java.net.*;
import java.util.*;

public class Q5 {
    private static final Map<String, String> cache = new HashMap<>();

    public static void main(String[] args) {
        String url = "https://httpbin.org/get";

        System.out.println("First request:");
        String response1 = getResponse(url);
        System.out.println(response1);

        System.out.println("\nSecond request (should use cache):");
        String response2 = getResponse(url);
        System.out.println(response2);
    }

    public static String getResponse(String urlString) {
        if (cache.containsKey(urlString)) {
            System.out.println("Fetched from cache.");
            return cache.get(urlString);
        }

        StringBuilder response = new StringBuilder();

        try {
            URL url = new URI(urlString).toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line).append("\n");
            }
            in.close();

            cache.put(urlString, response.toString());
            System.out.println("Fetched from web.");
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }

        return response.toString();
    }
}
