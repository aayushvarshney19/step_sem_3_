public class HackathonSeatingGridOptimizer {
    private static double rowAverage(int[] row) {
        if (row.length == 0) {
            return 0.0;
        }

        int totalScore = 0;
        for (int score : row) {
            totalScore += score;
        }
        return (double) totalScore / row.length;
    }

    public static String classifyRows(int[][] seatingScores, int threshold) {
        StringBuilder result = new StringBuilder();
        for (int row = 0; row < seatingScores.length; row++) {
            if (row > 0) {
                result.append(" | ");
            }
            String zone = rowAverage(seatingScores[row]) < threshold
                    ? "Quiet Zone"
                    : "Buzzing Zone";
            result.append("Row ").append(row).append(": ").append(zone);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int[][] seatingScores = {{40, 50, 45}, {85, 90, 95}, {30, 20, 25}};
        System.out.println(classifyRows(seatingScores, 60));
    }
}