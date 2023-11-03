import java.util.Scanner;
import java.util.Random;
 
public class HangmanGame {
    //une méthode qui prend un tableau de chaînes de caractères
    public static void main(String[] args) {
        //un objet pour lire input 
        Scanner scanner = new Scanner(System.in);
        String[] words = {"java", "programming", "computer", "hangman", "algorithm", "developer", "git"};
        //pour sélectionner un mot aléatoire dans le tableau
        Random random = new Random();
        String wordToGuess = words[random.nextInt(words.length)];
        //tentatives d'utilisateur  
        int maxAttempts = 8;
        int attemptsLeft = maxAttempts;
        StringBuilder guessedWord = new StringBuilder("_".repeat(wordToGuess.length()));
        boolean gameOver = false;

        System.out.println("Welcome to Hangman!");
        System.out.println("Try to guess the word.");
        System.out.println("You have " + maxAttempts + " attempts.");


//sera exécuté de manière répétée tant que la condition à l'intérieur des parenthèses est vraie.
        while (!gameOver) {
            System.out.println("Word: " + guessedWord);
            System.out.println("Attempts left: " + attemptsLeft);
            System.out.print("Enter a letter: ");
            char guess = scanner.next().charAt(0);
//une function si input = !letter
            if (!Character.isLetter(guess)) {
                System.out.println("Invalid input. Please enter a letter.");
                continue;
            }
//si la lettre devinée par le joueur est présente dans le mot à deviner.
            if (wordToGuess.contains(String.valueOf(guess))) {
                for (int i = 0; i < wordToGuess.length(); i++) {
                    if (wordToGuess.charAt(i) == guess) {
                        guessedWord.setCharAt(i, guess);
                    }
                }
                //Sinon, le nombre de tentatives est réduit
            } else {
                attemptsLeft--;
                System.out.println("Incorrect guess!");
                if (attemptsLeft == 0) {
                    gameOver = true;
                    System.out.println("You ran out of attempts. The word was: " + wordToGuess);
                }
            }

            if (guessedWord.toString().equals(wordToGuess)) {
                gameOver = true;
                System.out.println("Congratulations! You guessed the word: " + wordToGuess);
            }
        }

        scanner.close();
    }
}
