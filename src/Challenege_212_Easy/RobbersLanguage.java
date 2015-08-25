package Challenege_212_Easy;

/**
 * Created by Jonathan on 25/08/2015.
 * Java 1.8
 * Created for r/dailyProgrammer challenge 212 [Easy]
 */
public class RobbersLanguage {

    static String consonants = "bcdfghjklmnpqrstvwxz";


    public static void main(String[] args) {
        RobbersLanguage robbersLanguage = new RobbersLanguage();

        System.out.println("Challenge input 1: Tre Kronor är världens bästa ishockeylag. --> " + robbersLanguage.encode("Tre Kronor är världens bästa ishockeylag."));
        System.out.println("Challenge input 2: Vår kung är coolare än er kung. --> " + robbersLanguage.encode("Vår kung är coolare än er kung.") + "\n");

        System.out.println("Decode 1: " + robbersLanguage.decode(robbersLanguage.encode("Tre Kronor är världens bästa ishockeylag.")));
        System.out.println("Decode 2: " + robbersLanguage.decode(robbersLanguage.encode("Vår kung är coolare än er kung.")));

    }

    /**
     * Encode given word into Rövarspråket, 'Robbers Language'.
     * Replaces all consonants with consonant-'o'-consonant.
     *
     * @param stringToEncode String to encode.
     * @return Encoded string.
     */
    public String encode(String stringToEncode) {
        String result = "";

        for (int c = 0; c < stringToEncode.length(); c++) {
            char currentChar = stringToEncode.charAt(c);
            result += currentChar;
            if (consonants.contains(String.valueOf(currentChar).toLowerCase())) result += "o" + currentChar;
        }
        return result;
    }

    /**
     * Decodes given Rövarspråket into normal text.
     *
     * @param stringToDecode String to convert.
     * @return Decoded string.
     */
    public String decode(String stringToDecode) {
        String result = "";

        for (int c = 0; c < stringToDecode.length(); c++) {
            char currentChar = stringToDecode.charAt(c);
            result += currentChar;
            if (consonants.contains(String.valueOf(currentChar).toLowerCase()) && c < stringToDecode.length() - 2) {
                if (stringToDecode.charAt(c) == stringToDecode.charAt(c + 2) && stringToDecode.charAt(c + 1) == 'o') {
                    c += 2;
                }
            }
        }
        return result;
    }


}
