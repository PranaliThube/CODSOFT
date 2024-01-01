package CodeSoft;
import java.util.Random;
import java.util.Scanner;

public class RandomNo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to Guess the Number!");

        // Set the range for the random number
        int lowerLimit = 1;
        int upperLimit = 100;

        // Set the number of attempts and rounds
        int maxAttempts = 5;
        int roundsPlayed = 0;
        int totalAttempts = 0;

        boolean playAgain = true;

        while (playAgain) {
            System.out.println("\nRound " + (roundsPlayed + 1) + ": Guess the number between " + lowerLimit + " and " + upperLimit);

            int generatedNumber = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
            int attempts;

            for (attempts = 1; attempts <= maxAttempts; attempts++) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess == generatedNumber) {
                    System.out.println("Congratulations! Your guess " + userGuess + " is correct!");
                    totalAttempts += attempts;
                    break;
                } else if (userGuess < generatedNumber) {
                    System.out.println("Your guess is too low. Try again.");
                } else {
                    System.out.println("Your guess is too high. Try again.");
                }
            }

            if (attempts > maxAttempts) {
                System.out.println("Sorry, you've run out of attempts. The correct number was " + generatedNumber + ".");
            }

            roundsPlayed++;

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");

            if (playAgain) {
                System.out.println();
            }
        }

        System.out.println("\nGame Over!\nYou played " + roundsPlayed + " rounds with an average of " +
                (double) totalAttempts / roundsPlayed + " attempts per round.");

        scanner.close();
    }
}
