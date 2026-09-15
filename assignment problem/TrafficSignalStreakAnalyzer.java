import java.util.Scanner;

public class TrafficSignalStreakAnalyzer {
    public static void findLongestStreak(String signalLog) {
        if (signalLog.isEmpty()) {
            System.out.println("No Signal Readings Found");
            return;
        }

        char longestColor = signalLog.charAt(0);
        int longestLength = 1;
        char currentColor = signalLog.charAt(0);
        int currentLength = 1;

        for (int position = 1; position < signalLog.length(); position++) {
            if (signalLog.charAt(position) == currentColor) {
                currentLength++;
            } else {
                currentColor = signalLog.charAt(position);
                currentLength = 1;
            }

            if (currentLength > longestLength) {
                longestColor = currentColor;
                longestLength = currentLength;
            }
        }

        System.out.println("Longest Streak: '" + longestColor + "' repeated " + longestLength + " times");
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter signal log: ");
            findLongestStreak(scanner.nextLine());
        }
    }
}