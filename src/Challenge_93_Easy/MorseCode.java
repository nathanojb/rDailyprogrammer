package Challenge_93_Easy;

/**
 * Created by Jonathan on 30/08/2015.
 * Java 1.8
 * Created for r/dailyProgrammer challenge 93 [Easy]
 */
public class MorseCode {

    static String characters = "abcdefghijklmnopqrstuvwxyz1234567890,.?/- (";
    static String[] codes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
            ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-",
            ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--",
            "--..", ".----", "..---", "...--", "....-", ".....",
            "-....", "--...", "---..", "----.", "-----", //end of numbers --> punctuation
            "--..--", ".-.-.-", "..--..", "-..-.", "-....-", " ", "-.--.-"};


    public static void main(String[] args) {

        MorseCode morseCode = new MorseCode();

        System.out.println("Converted from morse: " + morseCode.intoLatin("... --- ..."));
        System.out.println("Converted from latin: " + morseCode.intoMorse("it actually works now.."));
        System.out.println(morseCode.intoLatin(morseCode.intoMorse(morseCode.intoLatin(morseCode.intoMorse("..even after repeated conversions.")))));

    }

    /**
     * Converts english into morse code.
     *
     * @param words the String to convert
     * @return the morse code equivalent. Morse characters will be separated by single space, words by dual space.
     */
    public String intoMorse(String words) {
        String result = "";
        for (char c : words.toCharArray()) {
            result += codes[characters.indexOf(c)];
            if (c != ' ') result += " ";
        }

        return result.substring(0, result.length() - 1); //gets rid of that pesky space at the end
    }

    /**
     * Converts morse code into english
     *
     * @param morse the Morse code to convert. Morse characters should be separated by single space, words by dual space.
     * @return the english equivalent string
     */
    public String intoLatin(String morse) {
        String result = "";
        String[] splitMorse = morse.split(" ");

        for (String s : splitMorse) {
            if (s.equals("")) result += " ";
            else for (int i = 0; i < codes.length; i++) if (s.equals(codes[i])) result += characters.charAt(i);
        }

        return result;
    }

}