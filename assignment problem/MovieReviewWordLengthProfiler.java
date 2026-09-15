import java.util.Scanner;

public class MovieReviewWordLengthProfiler {
    public static void classifyWordLengths(String review) {
        int shortWords = 0;
        int mediumWords = 0;
        int longWords = 0;
        String trimmedReview = review.trim();

        if (!trimmedReview.isEmpty()) {
            String[] words = trimmedReview.split("\\s+");
            for (String word : words) {
                if (word.length() <= 4) {
                    shortWords++;
                } else if (word.length() <= 8) {
                    mediumWords++;
                } else {
                    longWords++;
                }
            }
        }

        System.out.println("Short: " + shortWords + " | Medium: " + mediumWords + " | Long: " + longWords);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter movie review: ");
            classifyWordLengths(scanner.nextLine());
        }
    }
}