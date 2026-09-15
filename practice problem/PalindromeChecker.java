import java.util.Scanner;

public class PalindromeChecker {
    public static boolean isPalindromeIterative(String text) {
        for (int left = 0, right = text.length() - 1; left < right; left++, right--) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        return isPalindromeRecursive(text, 0, text.length() - 1);
    }

    private static boolean isPalindromeRecursive(String text, int left, int right) {
        if (left >= right) {
            return true;
        }
        return text.charAt(left) == text.charAt(right)
                && isPalindromeRecursive(text, left + 1, right - 1);
    }

    public static boolean isPalindromeArrayReversal(String text) {
        char[] characters = text.toCharArray();
        for (int left = 0, right = characters.length - 1; left < right; left++, right--) {
            char temporary = characters[left];
            characters[left] = characters[right];
            characters[right] = temporary;
        }
        return text.equals(new String(characters));
    }

    private static String resultLabel(boolean palindrome) {
        return palindrome ? "Palindrome" : "Not Palindrome";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        System.out.println("Iterative: " + resultLabel(isPalindromeIterative(text)));
        System.out.println("Recursive: " + resultLabel(isPalindromeRecursive(text)));
        System.out.println("Array Reversal: " + resultLabel(isPalindromeArrayReversal(text)));
        scanner.close();
    }
}