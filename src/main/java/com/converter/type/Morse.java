package com.converter.type;

public class Morse {

    private static StringBuilder result;

    private static final String[][] morseCodeTable = {
        {".-", "a"}, {"-...", "b"}, {"-.-.", "c"},
        {"-..", "d"}, {".", "e"}, {"..-.", "f"},
        {"--.", "g"}, {"....", "h"}, {"..", "i"},
        {".---", "j"}, {"-.-", "k"}, {".-..", "l"},
        {"--", "m"}, {"-.", "n"}, {"---", "o"},
        {".--.", "p"}, {"--.-", "q"}, {".-.", "r"},
        {"...", "s"}, {"-", "t"}, {"..-", "u"},
        {"...-", "v"}, {".--", "w"}, {"-..-", "x"},
        {"-.--", "y"}, {"--..", "z"}, {".----", "1"},
        {"..---", "2"}, {"...--", "3"}, {"....-", "4"},
        {".....", "5"}, {"-....", "6"}, {"--...", "7"},
        {"---..", "8"}, {"----.", "9"}, {"-----", "0"},
        {"/", " "}
    };

    public static String convertToMorse(String text) {
        result = new StringBuilder();
        for (char letter : text.toLowerCase().toCharArray()) {
            String code = getCodeForChar(letter);
            if (code != null) {
                result.append(code).append(" ");
            } else {
                result.append(letter).append(" ");
            }
        }
        return result.toString();
    }

    private static String getCodeForChar(char c) {
        for (String[] pair : morseCodeTable) {
            if (pair[1].charAt(0) == c) {
                return pair[0];
            }
        }
        return null;
    }

    public static String convertFromMorse(String morseCode) {
        result = new StringBuilder();
        String[] words = morseCode.split("\\s+");
        for (String word : words) {
            String letter = getCharForCode(word);
            if (letter != null) {
                result.append(letter);
            } else {
                result.append(word);
            }
        }
        return result.toString();
    }

    private static String getCharForCode(String code) {
        for (String[] pair : morseCodeTable) {
            if (pair[0].equals(code)) {
                return pair[1];
            }
        }
        return null;
    }
}
