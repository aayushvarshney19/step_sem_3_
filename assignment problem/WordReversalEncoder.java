import java.util.Scanner;

public class WordReversalEncoder {
    public static String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder encodedSentence = new StringBuilder();

        for (int wordIndex = 0; wordIndex < words.length; wordIndex++) {
            StringBuilder reversedWord = new StringBuilder();
            for (int characterIndex = words[wordIndex].length() - 1; characterIndex >= 0; characterIndex--) {
                reversedWord.append(words[wordIndex].charAt(characterIndex));
            }
            if (wordIndex > 0) {
                encodedSentence.append(' ');
            }
            encodedSentence.append(reversedWord);
        }
        return encodedSentence.toString();
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter sentence: ");
            System.out.println(reverseEachWord(scanner.nextLine()));
        }
    }
}