package Challenge_3_Hard;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Jonathan on 27/08/2015.
 * Java 1.8
 * Created for r/dailyProgrammer challenge 3 [Hard]
 */
public class Decipher {

    /*
    method:
    get words of same length
    sort each potential list word into alphabetical order
    compare sorted word against sorted current scrambled word
    if match we have a winner
    repeat for all words
    */

    public static void main(String[] args) {

        new Decipher().deScramble();
    }

    /**
     * Sorts character in string into alphabetical order
     *
     * @param original the string to sort.
     * @return the sorted string.
     */
    private String sortAlphabetically(String original) {
        char[] temp = original.toCharArray();
        Arrays.sort(temp);
        return new String(temp);
    }

    /**
     * De-scrambles words from a list using a list of words.
     */
    public void deScramble() {

        //shouldn't hard code the values but unlikely I'll re user this code elsewhere
        ArrayList<String> toDecipher = new ArrayList<String>(10);
        ArrayList<String> words = new ArrayList<String>(1273);

        try {
            //find files
            File toDecipherFile = new File(getClass().getResource("wordsToDecipher.txt").getPath());
            File wordsFile = new File(getClass().getResource("words.txt").getPath());

            //input scrambled words
            Scanner toDecipherFileScanner = new Scanner(toDecipherFile);
            while (toDecipherFileScanner.hasNext()) toDecipher.add(toDecipherFileScanner.next());
            toDecipherFileScanner.close();

            //input normal words
            Scanner wordsFileScanner = new Scanner(wordsFile);
            while (wordsFileScanner.hasNext()) words.add(wordsFileScanner.next());
            wordsFileScanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(2);
        }

        //for all words to be deciphered
        for (String current : toDecipher) {

            //sort the word & find it's length
            String currentSorted = sortAlphabetically(current);
            int length = current.length();

            //compare against sorted words of same length from master list
            for (String potential : words) {
                if (length == potential.length()) {
                    if (currentSorted.equals(sortAlphabetically(potential))) {
                        //if same, we have success, so can go to next word
                        System.out.println(current + " --> " + potential);
                        break;
                    }
                }
            }
        }
    }
}
