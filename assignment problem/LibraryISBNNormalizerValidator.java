import java.util.Scanner;

public class LibraryISBNNormalizerValidator {
    public static String normalizeCode(String raw) {
        String trimmedCode = raw.trim();
        if (trimmedCode.length() < 3) {
            return trimmedCode.toUpperCase();
        }

        return trimmedCode.substring(0, 3).toUpperCase()
                + trimmedCode.substring(3);
    }

    public static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: wrong length";
        }

        for (int index = 0; index < 3; index++) {
            if (!Character.isLetter(code.charAt(index))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        for (int index = 3; index < code.length(); index++) {
            if (!Character.isDigit(code.charAt(index))) {
                return "Invalid: code body must contain only digits";
            }
        }

        StringBuilder formattedCode = new StringBuilder();
        formattedCode.append('[').append(code.substring(0, 3)).append("] YEAR: ");
        formattedCode.append(code, 3, 7).append(" | CATALOG: ");
        formattedCode.append(code.substring(7));
        return formattedCode.toString();
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter ISBN-style code: ");
            String normalizedCode = normalizeCode(scanner.nextLine());
            System.out.println(validateAndFormat(normalizedCode));
        }
    }
}