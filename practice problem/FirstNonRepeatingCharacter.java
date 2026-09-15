import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FirstNonRepeatingCharacter {
    public static char findFirstNonRepeatingChar(String text) {
        Map<Character, Integer> frequencies = new HashMap<>();
        for (char character : text.toCharArray()) {
            frequencies.put(character, frequencies.getOrDefault(character, 0) + 1);
        }

        for (char character : text.toCharArray()) {
            if (frequencies.get(character) == 1) {
                return character;
            }
        }
        return '\0';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        char result = findFirstNonRepeatingChar(text);
        if (result == '\0') {
            System.out.println("No Non-Repeating Character Found");
        } else {
            System.out.println("First Non-Repeating Character: '" + result + "'");
        }
        scanner.close();
    }
}