import java.util.*;

public class restaurent {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Accepting restaurant ratings from the user
        System.out.print("Enter the number of restaurants: ");
        int numRestaurants = scanner.nextInt();
        int[] ratings = new int[numRestaurants];

        System.out.println("Enter the ratings of restaurants:");
        for (int i = 0; i < numRestaurants; i++) {
            System.out.print("Restaurant " + (i + 1) + ": ");
            ratings[i] = scanner.nextInt();
        }

        // Analyzing ratings
        Map<String, Integer> ratingCounts = new HashMap<>();
        Map<String, Integer> ratingSums = new HashMap<>();

        for (int rating : ratings) {
            String range = getRatingRange(rating);
            ratingCounts.put(range, ratingCounts.getOrDefault(range, 0) + 1);
            ratingSums.put(range, ratingSums.getOrDefault(range, 0) + rating);
        }

        // Output results
        System.out.println("\nAnalysis:");
        for (Map.Entry<String, Integer> entry : ratingCounts.entrySet()) {
            String range = entry.getKey();
            int count = entry.getValue();
            double average = (double) ratingSums.get(range) / count;
            System.out.println("Range " + range + ":");
            System.out.println("Number of restaurants: " + count);
            System.out.println("Average rating: " + average);
        }

        scanner.close();
    }

    // Method to determine the rating range
    private static String getRatingRange(int rating) {
        if (rating >= 1 && rating <= 5) {
            return "1-5";
        } else if (rating >= 6 && rating <= 10) {
            return "6-10";
        } else {
            return "Invalid";
        }
    }
}

