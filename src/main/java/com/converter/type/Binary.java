package com.converter.type;

public class Binary {

    private static StringBuilder result;
    
    public static String convertToBinary(String input) {
        result = new StringBuilder();
        for (char letter : input.toCharArray()) {
            String binaryChar = Integer.toBinaryString(letter);
            while (binaryChar.length() < 8) {
                binaryChar = "0" + binaryChar;
            }
            result.append(binaryChar).append(" ");
        }
        return result.toString();
    }

    public static String convertFromBinary(String input) {
        String[] binaryArray = input.split(" ");
        result = new StringBuilder();
        for (String letter : binaryArray) {
            int decimalValue = Integer.parseInt(letter, 2);
            char normalChar = (char) decimalValue;
            result.append(normalChar);
        }
        return result.toString();
    }
}
