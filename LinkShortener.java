import java.util.HashMap;
import java.util.Map;

public class LinkShortener {
    private Map<String, String> urlMap;

    public LinkShortener() {
        urlMap = new HashMap<>();
    }

    public String shortenUrl(String longUrl) {
        // Generate a short URL using a basic hash function
        String shortUrl = generateShortUrl(longUrl);

        // Check if the short URL is already in use
        while (urlMap.containsKey(shortUrl)) {
            // Handle collision by generating a new short URL
            shortUrl = generateShortUrl(longUrl + System.currentTimeMillis());
        }

        // Store the mapping between long URL and short URL
        urlMap.put(shortUrl, longUrl);

        return shortUrl;
    }

    public String expandUrl(String shortUrl) {
        // Check if the short URL is valid
        if (!urlMap.containsKey(shortUrl)) {
            // Handle invalid short URL
            return "Invalid short URL";
        }

        // Return the original long URL
        return urlMap.get(shortUrl);
    }

    private String generateShortUrl(String longUrl) {
        // Get the hash code of the long URL and ensure it's positive
        int hashCode = Math.abs(longUrl.hashCode());
        
        // Convert the hash code to a string
        String hash = String.valueOf(hashCode);
        
        // Ensure the short URL is at least 6 characters long
        if (hash.length() < 6) {
            hash = String.format("%06d", hashCode);
        }
        
        return hash.substring(0, 6);
    }

    public static void main(String[] args) {
        LinkShortener linkShortener = new LinkShortener();
        
        // Test shortening a URL
        String shortUrl = linkShortener.shortenUrl("https://example.com/long-url");
        System.out.println("Short URL: " + shortUrl);
        
        // Test expanding the URL
        String longUrl = linkShortener.expandUrl(shortUrl);
        System.out.println("Long URL: " + longUrl);
        
        // Test an invalid short URL
        String invalidUrl = linkShortener.expandUrl("875667");
        System.out.println("Invalid URL response: " + invalidUrl);
    }
}