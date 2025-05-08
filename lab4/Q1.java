// WAP in java to print the protocol, host, path, query for the URL http://example.com/index.html?name=test#section1 

import java.net.*;

public class Q1 {
    public static void main(String[] args) {
        try {
            // Define the URL
            String urlString = "http://example.com/index.html?name=test#section1";
            URI uri = new URI(urlString);
            URL url = uri.toURL();

            // Extract and print URL components
            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Host: " + url.getHost());
            System.out.println("Path: " + url.getPath());
            System.out.println("Query: " + url.getQuery());
            System.out.println("Fragment: " + url.getRef());

        } catch (MalformedURLException e) {
            System.err.println("Invalid URL: " + e.getMessage());
        } catch (URISyntaxException e) {
            System.err.println("Invalid URI: " + e.getMessage());
        }
    }
}
