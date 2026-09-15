import java.util.Arrays;

public class Candidate implements Comparable<Candidate> {
    private static final double CGPA_ONLY_THRESHOLD = 7.5;
    private static final double BORDERLINE_CGPA_THRESHOLD = 6.5;
    private static final int BORDERLINE_CODING_THRESHOLD = 60;

    private final String name;
    private final double cgpa;
    private final int codingScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    public static boolean isEligible(double cgpa) {
        return cgpa >= CGPA_ONLY_THRESHOLD;
    }

    public static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= BORDERLINE_CGPA_THRESHOLD && codingScore >= BORDERLINE_CODING_THRESHOLD;
    }

    private double compositeScore() {
        return cgpa * 10 + codingScore / 2.0;
    }

    @Override
    public int compareTo(Candidate other) {
        return Double.compare(other.compositeScore(), compositeScore());
    }

    public static String shortlistAndRank(Candidate[] candidates) {
        int eligibleCount = 0;
        for (Candidate candidate : candidates) {
            if (isEligible(candidate.cgpa) || isEligible(candidate.cgpa, candidate.codingScore)) {
                eligibleCount++;
            }
        }

        Candidate[] shortlisted = new Candidate[eligibleCount];
        int shortlistIndex = 0;
        for (Candidate candidate : candidates) {
            if (isEligible(candidate.cgpa) || isEligible(candidate.cgpa, candidate.codingScore)) {
                shortlisted[shortlistIndex++] = candidate;
            }
        }

        Arrays.sort(shortlisted);
        StringBuilder result = new StringBuilder();
        for (int index = 0; index < shortlisted.length; index++) {
            if (index > 0) {
                result.append(" | ");
            }
            result.append(index + 1)
                    .append(". ")
                    .append(shortlisted[index].name)
                    .append(" (")
                    .append(String.format("%.1f", shortlisted[index].compositeScore()))
                    .append(")");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Candidate[] candidates = {
                new Candidate("Aisha", 8.2, 40),
                new Candidate("Rohit", 6.8, 65),
                new Candidate("Meena", 6.0, 90),
                new Candidate("Karan", 7.5, 20)
        };
        System.out.println(shortlistAndRank(candidates));
    }
}