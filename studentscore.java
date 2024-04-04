import java.util.*;

public class studentscore {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Accepting test scores from the user
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        int[] scores = new int[numStudents];

        System.out.println("Enter the test scores of students:");
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Student " + (i + 1) + ": ");
            scores[i] = scanner.nextInt();
        }

        // Calculating average score
        double average = calculateAverage(scores);

        // Calculating median score
        double median = calculateMedian(scores);

        // Counting students above, at, and below average
        int aboveAverageCount = 0;
        int atAverageCount = 0;
        int belowAverageCount = 0;

        for (int score : scores) {
            if (score > average) {
                aboveAverageCount++;
            } else if (score < average) {
                belowAverageCount++;
            } else {
                atAverageCount++;
            }
        }

        // Output results
        System.out.println("\nAnalysis:");
        System.out.println("Average score: " + average);
        System.out.println("Median score: " + median);
        System.out.println("Number of students above average: " + aboveAverageCount);
        System.out.println("Number of students at average: " + atAverageCount);
        System.out.println("Number of students below average: " + belowAverageCount);

        scanner.close();
    }

    // Method to calculate the average score
    private static double calculateAverage(int[] scores) {
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return (double) sum / scores.length;
    }

    // Method to calculate the median score
    private static double calculateMedian(int[] scores) {
        Arrays.sort(scores);
        int middle = scores.length / 2;
        if (scores.length % 2 == 0) {
            return (double) (scores[middle - 1] + scores[middle]) / 2;
        } else {
            return scores[middle];
        }
    }
}
