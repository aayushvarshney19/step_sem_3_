import java.util.Scanner;

public class TypingSpeedAccuracyChecker {
    public static void checkTypingAccuracy(String original, String typed) {
        int charactersToCompare = Math.min(original.length(), typed.length());
        int matchedCharacters = 0;
        int firstMismatch = -1;

        for (int position = 0; position < charactersToCompare; position++) {
            if (original.charAt(position) == typed.charAt(position)) {
                matchedCharacters++;
            } else if (firstMismatch == -1) {
                firstMismatch = position;
            }
        }

        if (typed.length() != original.length() && firstMismatch == -1) {
            firstMismatch = charactersToCompare;
        }

        double accuracy = original.length() == 0
                ? (typed.length() == 0 ? 100.0 : 0.0)
                : matchedCharacters * 100.0 / original.length();
        System.out.printf("Matched: %d/%d | Accuracy: %.2f%%", matchedCharacters, original.length(), accuracy);

        if (firstMismatch == -1) {
            System.out.println(" | No Mismatches");
        } else if (firstMismatch < original.length() && firstMismatch < typed.length()) {
            System.out.printf(" | First Mismatch at position %d ('%c' vs '%c')%n",
                    firstMismatch + 1, original.charAt(firstMismatch), typed.charAt(firstMismatch));
        } else if (firstMismatch < original.length()) {
            System.out.printf(" | First Mismatch at position %d ('%c' vs missing character)%n",
                    firstMismatch + 1, original.charAt(firstMismatch));
        } else {
            System.out.printf(" | First Mismatch at position %d (extra character '%c')%n",
                    firstMismatch + 1, typed.charAt(firstMismatch));
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter original passage: ");
            String original = scanner.nextLine();
            System.out.print("Enter typed passage: ");
            String typed = scanner.nextLine();
            checkTypingAccuracy(original, typed);
        }
    }
}