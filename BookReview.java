import java.util.*;

class BookReview {
    private String title;
    private int rating;

    public BookReview(String title, int rating) {
        this.title = title;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public int getRating() {
        return rating;
    }
}

public class BookReviewAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<BookReview> reviews = new ArrayList<>();

        // Accepting book review details
        System.out.print("Enter the number of book reviews: ");
        int numReviews = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        for (int i = 0; i < numReviews; i++) {
            System.out.println("Enter details for book review " + (i + 1) + ":");
            System.out.print("Book title: ");
            String title = scanner.nextLine();
            System.out.print("Rating (out of 10): ");
            int rating = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            BookReview review = new BookRev
