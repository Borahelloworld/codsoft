package codsoft;
import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;

            System.out.println("\nI've selected a number between " + minRange + " and " + maxRange + ". Can you guess it?");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    score += maxAttempts - attempts + 1;
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next();

            if ("no".equalsIgnoreCase(playAgain)) {
                break;
            } else if ("yes".equalsIgnoreCase(playAgain)) {
                System.out.println("Your current score is: " + score);
            } else {
                System.out.println("Invalid input. Exiting the game.");
                break;
            }
        } while (true);

        System.out.println("Thanks for playing! Your final score is: " + score);
        scanner.close();
    }
}
