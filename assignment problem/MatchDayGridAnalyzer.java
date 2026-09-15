public class MatchDayGridAnalyzer {
    private static double rowAverage(int[] row) {
        if (row.length == 0) {
            return 0.0;
        }

        int totalRuns = 0;
        for (int runs : row) {
            totalRuns += runs;
        }
        return (double) totalRuns / row.length;
    }

    public static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder result = new StringBuilder();
        for (int match = 0; match < runsPerOver.length; match++) {
            if (match > 0) {
                result.append(" | ");
            }
            String classification = rowAverage(runsPerOver[match]) >= threshold
                    ? "Power Surge"
                    : "Normal";
            result.append("Match ").append(match).append(": ").append(classification);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int[][] runsPerOver = {{4, 6, 8}, {10, 12, 14}, {2, 3, 1}};
        System.out.println(classifyMatches(runsPerOver, 8));
    }
}