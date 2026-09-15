import java.util.Scanner;

public class BankTransactionReferenceValidator {
    public static String normalizeReference(String raw) {
        String trimmedReference = raw.trim();
        if (trimmedReference.length() < 3) {
            return trimmedReference.toUpperCase();
        }

        return trimmedReference.substring(0, 3).toUpperCase()
                + trimmedReference.substring(3);
    }

    public static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }

        for (int index = 0; index < 3; index++) {
            if (!Character.isLetter(reference.charAt(index))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        for (int index = 3; index < reference.length(); index++) {
            if (!Character.isDigit(reference.charAt(index))) {
                return "Invalid: reference body must contain only digits";
            }
        }

        StringBuilder formattedReference = new StringBuilder();
        formattedReference.append('[').append(reference.substring(0, 3)).append("] DATE: ");
        formattedReference.append(reference, 3, 5).append('/');
        formattedReference.append(reference, 5, 7).append('/');
        formattedReference.append(reference, 7, 9).append(" | SEQ: ");
        formattedReference.append(reference.substring(9));
        return formattedReference.toString();
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter transaction reference: ");
            String normalizedReference = normalizeReference(scanner.nextLine());
            System.out.println(validateAndFormat(normalizedReference));
        }
    }
}