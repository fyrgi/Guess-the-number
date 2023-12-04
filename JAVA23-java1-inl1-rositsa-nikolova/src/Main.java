import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // the values are in final vars just in case we want the game to allow bigger random numbers
        final int MINNUMBER = 1, MAXNUMBER = 100;
        // just for good measure I have an exit condition that is always the maxnumber + 1
        int exitCondition = MAXNUMBER+1;
        boolean guessed = false, game = true;
        int currentGuess;
        // user-friendly message that uses the values that are preset.
        System.out.printf("Welcome to my game. I am storing number which is between %s and %s (including them).\n" +
                        "Write your guess and I will tell you if you are right.\nWrite %s if you want to exit\n"
                ,MINNUMBER,MAXNUMBER, exitCondition);
        // TODO learn about naming convention for scanners.
        Scanner userInput = new Scanner(System.in);
        // run the game until an exit condition is met. The exit condition is game to be false.
        do {
            Random number = new Random();
            // every time a new game starts it will generate and assign a random number.
            int myNumber = number.nextInt(MAXNUMBER+1);
            //System.out.println(myNumber);
            int numberOfGuesses = 0;
            // guessing cycle. I want the current game to continue until the person guesses right
            // or decides to exit the game.
            while (guessed == false && game == true){
                do {
                    // Asking the user for valid input. The cycle is to
                    currentGuess = userInput.nextInt();
                    if (currentGuess > exitCondition || currentGuess <= 0) {
                        System.out.printf("Please provide a valid number between %s and %s or %s if you want to exit\n"
                                , MINNUMBER, MAXNUMBER, exitCondition);
                    } else if (currentGuess == exitCondition){
                        System.out.println("Thank you for playing!");
                        game = false;
                    }
                } while (currentGuess > exitCondition || currentGuess <= 0);
                /* everytime when the user has provided a valid number in the expected range
                a function that compares the user input with the game's generated number. */
                if(game == true){
                    numberOfGuesses++;
                    guessed = CompareValues(currentGuess, myNumber, numberOfGuesses);
                }
            }
            guessed = false;
        } while (game == true);
    }
    // The function that compares the current guess to the actual number, print's a message and returns a boolean.
    public static boolean CompareValues(int currentGuess, int myNumber, int numberOfGuesses){
        boolean resultat = false;
        if ( currentGuess < myNumber){
            System.out.printf("%s is smaller than my number\n", currentGuess);
        } else if (currentGuess > myNumber){
            System.out.printf("%s is bigger than my number\n", currentGuess);
        } else {
            System.out.printf("Congratulations! %s is my number!\nYou've guessed it with %s attempt(s).\n\n" +
                    "New game started. If you want to exit write 101.\n", currentGuess, numberOfGuesses);
            resultat = true;
        }
        return resultat;
    }
}