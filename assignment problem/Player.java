import java.util.Arrays;

public class Player implements Comparable<Player> {
    private static final int ESTABLISHED_MATCHES = 10;
    private static final int DEVELOPING_MATCHES = 5;

    private final String name;
    private final int matchesPlayed;
    private final double battingAverage;
    private final boolean injured;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    public static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= ESTABLISHED_MATCHES;
    }

    public static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= DEVELOPING_MATCHES && !injured;
    }

    @Override
    public int compareTo(Player other) {
        return Double.compare(other.battingAverage, battingAverage);
    }

    public static String draftAndRank(Player[] players) {
        int draftableCount = 0;
        for (Player player : players) {
            if (isDraftable(player.matchesPlayed)
                    || isDraftable(player.matchesPlayed, player.injured)) {
                draftableCount++;
            }
        }

        Player[] draftablePlayers = new Player[draftableCount];
        int draftableIndex = 0;
        for (Player player : players) {
            if (isDraftable(player.matchesPlayed)
                    || isDraftable(player.matchesPlayed, player.injured)) {
                draftablePlayers[draftableIndex++] = player;
            }
        }

        Arrays.sort(draftablePlayers);
        StringBuilder result = new StringBuilder();
        for (int index = 0; index < draftablePlayers.length; index++) {
            if (index > 0) {
                result.append(" | ");
            }
            result.append(index + 1).append(". ").append(draftablePlayers[index].name);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Player[] players = {
                new Player("Virat", 15, 48.0, false),
                new Player("Rahul", 7, 55.0, false),
                new Player("Sameer", 3, 60.0, false),
                new Player("Dev", 12, 20.0, true)
        };
        System.out.println(draftAndRank(players));
    }
}