import java.util.Scanner;

public class LinkShortenerCLI {
    public static void main(String[] args) {
        LinkShortener linkShortener = new LinkShortener();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to Link Shortener CLI");
            System.out.println("1. Shorten URL");
            System.out.println("2. Expand URL");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the long URL: ");
                    String longUrl = scanner.nextLine();
                    String shortUrl = linkShortener.shortenUrl(longUrl);
                    System.out.println("Shortened URL: " + shortUrl);
                    break;

                case 2:
                    System.out.print("Enter the short URL: ");
                    String shortUrlInput = scanner.nextLine();
                    String expandedUrl = linkShortener.expandUrl(shortUrlInput);
                    System.out.println("Original URL: " + expandedUrl);
                    break;

                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
            System.out.println();
        }
    }
}
