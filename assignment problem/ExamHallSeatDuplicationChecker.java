import java.util.Scanner;

public class ExamHallSeatDuplicationChecker {
    public static void checkDuplicateSeats(int[] seatNumbers) {
        boolean foundDuplicate = false;

        for (int current = 0; current < seatNumbers.length; current++) {
            boolean alreadyPrinted = false;
            for (int previous = 0; previous < current; previous++) {
                if (seatNumbers[current] == seatNumbers[previous]) {
                    alreadyPrinted = true;
                    break;
                }
            }

            if (alreadyPrinted) {
                continue;
            }

            for (int comparison = current + 1; comparison < seatNumbers.length; comparison++) {
                if (seatNumbers[current] == seatNumbers[comparison]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[current]);
                    foundDuplicate = true;
                    break;
                }
            }
        }

        if (!foundDuplicate) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the number of students: ");
            int studentCount = scanner.nextInt();
            int[] seatNumbers = new int[studentCount];

            for (int student = 0; student < studentCount; student++) {
                System.out.print("Enter seat number for student " + (student + 1) + ": ");
                seatNumbers[student] = scanner.nextInt();
            }

            checkDuplicateSeats(seatNumbers);
        }
    }
}