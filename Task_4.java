package codsoft;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
public class Task_4 {
        private static int score = 0;
        private static int currentQuestionIndex = 0;
        private static boolean[] isAnswered;
        private static boolean timeout = false;

        private static final String[] questions = {
                "What is the capital of France?",
                "Which planet is known as the Red Planet?",
                "What is the largest mammal in the world?",
                "Who wrote Romeo and Juliet?",
                "What is the chemical symbol for gold?"
        };

        private static final String[][] options = {
                {"Paris", "Berlin", "London", "Madrid"},
                {"Mars", "Venus", "Jupiter", "Saturn"},
                {"Elephant", "Blue Whale", "Giraffe", "Hippopotamus"},
                {"William Shakespeare", "Jane Austen", "Charles Dickens", "Mark Twain"},
                {"Au", "Ag", "Cu", "Fe"}
        };

        private static final int[] correctAnswers = {0, 2, 1, 0, 0};
        private static final int quizDurationInSeconds = 20;

        public static void main(String[] args) {
            isAnswered = new boolean[questions.length];

            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    timeout = true;
                    displayResult();
                    System.exit(0);
                }
            }, quizDurationInSeconds * 1000);

            while (currentQuestionIndex < questions.length) {
                displayQuestion();
                int userAnswer = getUserAnswer();
                checkAnswer(userAnswer);
            }

            timer.cancel();
            displayResult();
        }

        private static void displayQuestion() {
            System.out.println("Question " + (currentQuestionIndex + 1) + ": " + questions[currentQuestionIndex]);

            for (int i = 0; i < options[currentQuestionIndex].length; i++) {
                System.out.println((i + 1) + ". " + options[currentQuestionIndex][i]);
            }
        }

        private static int getUserAnswer() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Your answer (1-4): ");
            int userAnswer = scanner.nextInt();
            isAnswered[currentQuestionIndex] = true;
            return userAnswer - 1;
        }

        private static void checkAnswer(int userAnswer) {
            if (!timeout) {
                if (userAnswer == correctAnswers[currentQuestionIndex]) {
                    System.out.println("Correct!\n");
                    score++;
                } else {
                    System.out.println("Incorrect!\n");
                }
                currentQuestionIndex++;
            }
        }

        private static void displayResult() {
            System.out.println("Quiz completed!");
            System.out.println("Your final score: " + score + "/" + questions.length);

            System.out.println("\nSummary:");

            for (int i = 0; i < questions.length; i++) {
                System.out.println("Q" + (i + 1) + ": " + (isAnswered[i] ? "Answered" : "Not Answered"));
            }
        }
}
