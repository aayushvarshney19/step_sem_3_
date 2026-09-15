import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class StopWordFilteredWordFrequency {
    public static void printFilteredWordFrequency(String feedback) {
        Set<String> stopWords = new HashSet<>(Arrays.asList("the", "was", "and", "a", "is", "of", "in"));
        Map<String, Integer> frequencies = new HashMap<>();
        String cleanedFeedback = feedback.toLowerCase().replace(".", "").replace(",", "");
        String trimmedFeedback = cleanedFeedback.trim();

        if (!trimmedFeedback.isEmpty()) {
            String[] words = trimmedFeedback.split("\\s+");
            for (String word : words) {
                if (!stopWords.contains(word)) {
                    frequencies.put(word, frequencies.getOrDefault(word, 0) + 1);
                }
            }
        }

        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(frequencies.entrySet());
        sortedEntries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        for (Map.Entry<String, Integer> entry : sortedEntries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter feedback: ");
            printFilteredWordFrequency(scanner.nextLine());
        }
    }
}