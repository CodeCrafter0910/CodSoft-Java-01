import java.util.Scanner;
import java.util.Random;
public class GuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalAttempts = 0;
        int roundsWon = 0;
        System.out.println("Welcome to the Guess the Number Game!");
        while (playAgain) {
            int secretNumber = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;
            System.out.println("\nI've picked a number between 1 and 100. Can you guess it?");
            while (attempts < 5) { 
                System.out.print("Enter your guess (Attempt " + (attempts + 1) + "/5): ");
                int guess = scanner.nextInt();
                attempts++;
                totalAttempts++;
                if (guess < secretNumber) {
                    System.out.println("Too low!");
                } else if (guess > secretNumber) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Congratulations! You've guessed the number " + secretNumber + " correctly in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    roundsWon++;
                    break;
                }
            }
            if (!guessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The correct number was " + secretNumber + ".");
            }
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next().toLowerCase();
            if (!playAgainResponse.equals("yes")) {
                playAgain = false;
            }
        }
        System.out.println("Game over!");
        System.out.println("Total attempts: " + totalAttempts);
        System.out.println("Rounds won: " + roundsWon);
        scanner.close();
    }
}
