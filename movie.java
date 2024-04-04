import java.util.*;

class Movie {
    private String title;
    private String rating;
    private double userRating;

    public Movie(String title, String rating, double userRating) {
        this.title = title;
        this.rating = rating;
        this.userRating = userRating;
    }

    public String getTitle() {
        return title;
    }

    public String getRating() {
        return rating;
    }

    public double getUserRating() {
        return userRating;
    }
}

public class MovieRatingsAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Movie> movies = new ArrayList<>();

        // Accepting movie details
        System.out.print("Enter the number of movies: ");
        int numMovies = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        for (int i = 0; i < numMovies; i++) {
            System.out.println("Enter details for movie " + (i + 1) + ":");
            System.out.print("Title: ");
            String title = scanner.nextLine();
            System.out.print("Rating (e.g., PG, PG-13, R): ");
            String rating = scanner.nextLine();
            System.out.print("User rating (out of 10): ");
            double userRating = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            Movie movie = new Movie(title, rating, userRating);
            movies.add(movie);
        }

        // Calculating statistics
        Map<String, Integer> movieCounts = new HashMap<>();
        Map<String, Double> averageRatings = new HashMap<>();
        for (Movie movie : movies) {
            String rating = movie.getRating();
            int count = movieCounts.getOrDefault(rating, 0) + 1;
            movieCounts.put(rating, count);

            double totalRating = averageRatings.getOrDefault(rating, 0.0) + movie.getUserRating();
            averageRatings.put(rating, totalRating);
        }

        // Displaying statistics
        System.out.println("\nMovie ratings statistics:");
        for (Map.Entry<String, Integer> entry : movieCounts.entrySet()) {
            String rating = entry.getKey();
            int count = entry.getValue();
            double averageRating = averageRatings.get(rating) / count;
            System.out.println(rating + ": " + count + " movies, average rating: " + averageRating);
        }
    }
}

