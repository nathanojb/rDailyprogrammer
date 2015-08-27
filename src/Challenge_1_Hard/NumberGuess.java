package Challenge_1_Hard;

import java.util.Scanner;

/**
 * Created by Jonathan on 27/08/2015.
 * Java 1.8
 * Created for r/dailyProgrammer challenge 1 [Hard]
 */
public class NumberGuess {

    int min = 0;
    int max = 100;
    char reply;
    int guess;
    boolean guessed = false;

    public static void main(String[] args) {

        new NumberGuess().play();

    }

    /**
     * Plays the number guessing game.
     * Uses binary search so a bit boring for the player.. but it works every time.
     */
    public void play() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the guessing game, choose a number between 1 and " +
                max + " inclusive and I will guess it.");


        while (!guessed) {

            guess = (min + max) / 2;

            System.out.println("Is your number " + guess + "?. Yes (y), it's lower (l), it's higher (h)");
            reply = scanner.next().charAt(0);

            if (reply == 'y') {
                System.out.println("Huzzah!");
                guessed = true;
            } else if (reply == 'l') max = guess;
            else if (reply == 'h') min = guess;

        }
    }
}

