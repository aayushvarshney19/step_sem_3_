import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        boolean playerWins = (playerMove.equals("Rock") && computerMove.equals("Scissors"))
                || (playerMove.equals("Paper") && computerMove.equals("Rock"))
                || (playerMove.equals("Scissors") && computerMove.equals("Paper"));
        return playerWins ? "Player Wins" : "Computer Wins";
    }

    private static String formatMove(String move) {
        String normalizedMove = move.trim().toLowerCase();
        if (normalizedMove.equals("rock")) {
            return "Rock";
        } else if (normalizedMove.equals("paper")) {
            return "Paper";
        } else if (normalizedMove.equals("scissors")) {
            return "Scissors";
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] moves = {"Rock", "Paper", "Scissors"};
        String[] playerMoves = new String[5];
        String[] computerMoves = new String[5];
        String[] results = new String[5];
        int wins = 0;
        int losses = 0;
        int draws = 0;

        for (int round = 0; round < playerMoves.length; round++) {
            String playerMove;
            do {
                System.out.print("Round " + (round + 1) + " - Enter Rock, Paper, or Scissors: ");
                playerMove = formatMove(scanner.nextLine());
                if (playerMove == null) {
                    System.out.println("Please enter a valid move.");
                }
            } while (playerMove == null);

            String computerMove = moves[random.nextInt(moves.length)];
            String result = playRound(playerMove, computerMove);
            playerMoves[round] = playerMove;
            computerMoves[round] = computerMove;
            results[round] = result;

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
            System.out.println("Result: " + result);
        }

        System.out.println("\nFinal Summary");
        System.out.printf("%-8s %-14s %-16s %-15s%n", "Round", "Player Move", "Computer Move", "Result");
        for (int round = 0; round < playerMoves.length; round++) {
            System.out.printf("%-8d %-14s %-16s %-15s%n",
                    round + 1, playerMoves[round], computerMoves[round], results[round]);
        }
        double winPercentage = wins * 100.0 / playerMoves.length;
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n",
                wins, losses, draws, winPercentage);
        scanner.close();
    }
}