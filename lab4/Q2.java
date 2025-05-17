// WAP to find the resolved uri from the baseUri =http://example.com & relativeUri  =/path/to/resource?query=123#fragment 

import java.net.URI;
import java.net.URISyntaxException;

public class Q2 {
    public static void main(String[] args) {
        try {
            URI baseUri = new URI("http://example.com");
            URI relativeUri = new URI("/path/to/resource?query=123#fragment");

            URI resolvedUri = baseUri.resolve(relativeUri);

            System.out.println("Resolved URI: " + resolvedUri);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
