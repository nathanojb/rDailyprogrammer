package Challenge_149_Easy;

/**
 * Created by Jonathan on 25/08/2015.
 * Java 1.8
 * Created for r/dailyProgrammer challenge 149 [Easy]
 */
public class Disemvoweling {

    public static void main(String[] args) {
        String[] answer = new Disemvoweling().disemvowel("the quick brown fox jumped over the lazy dog.");
        System.out.println(answer[0] + " , " + answer[1]);

    }

    /**
     * Removes vowels from the passed string.
     *
     * @param toDisemvowel The string to disemvowel.
     * @return String array. Position 0 contains the disemvoweled string, position 1 contains the removed vowels.
     */
    public String[] disemvowel(String toDisemvowel) {
        String[] result = new String[2];
        result[0] = toDisemvowel.replaceAll("[aeiou ]", "");
        result[1] = toDisemvowel.replaceAll("[^aeiou]", "");
        return result;
    }


}
