import java.util.Random;

public class BmiTeamCalculator {
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal";
        } else if (bmi < 30) {
            return "Overweight";
        }
        return "Obese";
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        if (heights.length != weights.length) {
            throw new IllegalArgumentException("Heights and weights must have the same length.");
        }

        System.out.printf("%-10s %-14s %-14s %-10s %-15s%n", "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        for (int person = 0; person < heights.length; person++) {
            double bmi = weights[person] / (heights[person] * heights[person]);
            System.out.printf("%-10d %-14.2f %-14.2f %-10.2f %-15s%n",
                    person + 1, heights[person], weights[person], bmi, getBmiStatus(bmi));
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        double[] heights = new double[10];
        double[] weights = new double[10];

        for (int person = 0; person < heights.length; person++) {
            heights[person] = 1.50 + random.nextDouble() * 0.40;
            weights[person] = 45 + random.nextDouble() * 65;
        }

        printWellnessReport(heights, weights);
    }
}