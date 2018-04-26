package rotacsufbo.encrypt;

import java.util.*;

public class Decrypt {

    public static String decrypt(String encrypted) { 
        final int ENCRYPTION_ALGORITHMS = 5;

        //b64 decode
        byte[] decoded = Base64.getDecoder().decode(encrypted);
        String decodedStr = new String(decoded);

        // get decryption alg used
        int encryptorUsed = 10 * Character.getNumericValue(decodedStr.charAt(0)) + Character.getNumericValue(decodedStr.charAt(1));
        encryptorUsed %= ENCRYPTION_ALGORITHMS;

        String decryptedString = decodedStr.substring(2, decodedStr.length()-50);
        String key = decodedStr.substring(decodedStr.length()-50);
        //        decryptedString=decryptedString.substring(0, decryptedString.length()-50);


        if (encryptorUsed == 0) {
            // OTP
            decryptedString = dec05(decryptedString, key);
        } else if (encryptorUsed == 1) {
            // VIG
            decryptedString = dec01(decryptedString, key);
        } else if (encryptorUsed == 2) {
            // SUB
            decryptedString = dec02(decryptedString, key);
        } else if (encryptorUsed == 3 ) {
            // CAE
            decryptedString = dec03(decryptedString, 10);
        } else if (encryptorUsed == 4) {
            // ATB
            decryptedString = dec04(decryptedString, key);
        }
        return decryptedString;
    }

    /**
     * Generating a list where each number corresponds to its position in the list.
     *
     * @return
     */
    public static List generateNumberList() {
        List<String> places = Arrays.asList("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
        return places;
    }

    /**
     * This is the decryption method for the Vigenere cipher technique. It would decrypt letters that followed this encryption method, but
     * numbers was decrypted by the other digit encryption technique and punctuation was left as is.
     * @param encryptedText
     * @param key
     * @return
     */
    public static String dec01(String encryptedText, final String key) {
        String decryptedText = "";
        List<String> numberList = generateNumberList();
        for (int i = 0, j = 0; i < encryptedText.length(); i++) {
            char c = encryptedText.charAt(i);
            if (Character.isLowerCase(c)) {
                decryptedText += (char) ((c - key.charAt(j) + 26) % 26 + 'a');
                j = ++j % key.length();
            } else if (Character.isUpperCase(c)) {
                decryptedText += (char) ((c - Character.toUpperCase(key.charAt(j)) + 26) % 26 + 'A');
                j = ++j % key.length();
            } else if (Character.isDigit(c)) {
                decryptedText += decryptDigit(numberList, c);
            } else {
                decryptedText += (char) c;

            }
        }
        return decryptedText;
    }

    /**
     * This decryption takes care of the Substitution encryption technique. If the predetermined offset provides an ASCII value
     * which is less than 32 (the lowest acceptable ASCII value for characters relevant), it would wrap around and proceed through the
     * higher ASCII values.
     * @param encryptedText
     * @return
     */
    public static String dec02(String encryptedText, String key) {
        String decryptedString = "";
        for (char c : encryptedText.toCharArray()) {
            int newIntegerValue = (int) c - 69;
            if (newIntegerValue < 32) {
                int offset = 32 - (newIntegerValue + 1);
                newIntegerValue = 126 - offset;
            }
            decryptedString += (char) newIntegerValue;
        }

        return decryptedString;
    }

    /**
     * Decrypting the Atbash cipher involves looking at the index of a character in the encrypted string and then finding the position of the
     * character in the forward traversed string.
     * @param encryptedText
     * @return
     */
    public static String dec04(String encryptedText, String key) {
        String ordered = generateAtbashOrderedString();
        StringBuffer buffer = new StringBuffer(ordered);
        String reverse = buffer.reverse().toString();
        String decryptedString = "";

        for (int i = 0; i < encryptedText.length(); i++) {
            char currentCharacter = encryptedText.charAt(i);
            int indexOfCurrentCharacter = reverse.indexOf(currentCharacter);
            decryptedString += ordered.charAt(indexOfCurrentCharacter);
        }

        return decryptedString;


    }

    /**
     * Generating the ordered ASCII character to refer to the decrypted characters for the Atbash cipher technique.
     * @return
     */
    public static String generateAtbashOrderedString() {
        String ordered = "";
        for (int i = 32; i <= 126; i++) {
            ordered += (char) i;
        }

        return ordered;
    }

    /**
     * Decrypting a string of only numbers - implying the decrypted string is number based as well. Each digit is decrypted by the numerical encryption
     * technique.
     * @param encryptedNumbers
     * @return
     */
    public static String decryptDigitString(String encryptedNumbers) {

        List<String> numberList = generateNumberList();
        String decryptedNumbers = "";
        for (char i : encryptedNumbers.toCharArray()) {
            decryptedNumbers += Character.toString(decryptDigit(numberList, i));
        }
        return decryptedNumbers;
    }

    /**
     * Using the offset value, and then 26 - offset, this technique would implement the same techniques as the CaesarEncrypt method.
     * @param encrypted
     * @param offset
     * @return
     */
    public static String dec03(String encrypted, int offset) {

        offset = 26 - offset;

        offset = offset % 26 + 26;
        String decrypted = "";
        List<String> numberList = generateNumberList();
        for (char i : encrypted.toCharArray()) {
            if (Character.isLetter(i)) {
                if (Character.isUpperCase(i)) {
                    decrypted += ((char) ('A' + (i - 'A' + offset) % 26));
                } else {
                    decrypted += ((char) ('a' + (i - 'a' + offset) % 26));
                }
            } else if (Character.isDigit(i)) {
                decrypted += Character.toString(decryptDigit(numberList, i));
            } else {
                decrypted += i;
            }
        }
        return decrypted;
    }

    /**
     *  Converts the letters to the corresponding position on the alphabet a = 1, b = 2 ...
     * @param text
     * @return
     */
    public static int[] convertToAlphabetIntegerArray(String text) {
        int[] alphabetArray = new int[text.length()];
        int i = 0;

        for (char c : text.toCharArray()) {
            if (!Character.isLetter(c)) {
                alphabetArray[i] = (int) c;
            } else {
                if (Character.isUpperCase(c)) {
                    alphabetArray[i] = ((int) c - 'A') * -1 - 1;
                } else {
                    alphabetArray[i] = (int) c - 'a' + 1;
                }

            }
            i++;
        }
        return alphabetArray;
    }

    /**
     * Decrypting a digit to it's original value. Now it is traversing backwards to see the next number below the one currently being
     * investigated to see which numbers have the same length in word form. This too has wrap-around abilities where if there are no numbers below it,
     * it would wrap around and go to the highest number (9) and decrement.
     * @param numberList
     * @param c
     * @return
     */
    public static char decryptDigit(List numberList, char c) {
        if (!Character.isDigit(c)) {
            return c;
        }
        int numericalValue = Character.getNumericValue(c);
        String numberAsString = (String) numberList.get(numericalValue);
        boolean needToGetDigit = true;
        char returnDigit = ' ';
        int iterationNumber = 0;
        for (int i = numberList.size() - 1,j=numberList.size()-1; needToGetDigit; i--) {
            if(j < 0 ){
                j = numberList.size() - 1;
            }
            String value = (String) numberList.get(j);
            if ((j < numericalValue && numberAsString.length() == value.length()) ||
                    (value.length() == numberAsString.length() && iterationNumber >= numberList.size())) {
                int encryptedDigit = j;
                returnDigit = (char) (encryptedDigit + '0');
                needToGetDigit = false;
                break;
            }
            iterationNumber++;
            j--;
        }
        return returnDigit;
    }

    /**
     * This method would decrypt a character according to the one-time pad technique. This would use the 1- 26 scale
     * for lower case letters, (-1 to -26) scale for Upper case letters. For digits, the novel digit encryption technique
     * would be used and punctuation would have been no change.
     * @param encryptedText
     * @param key
     * @return
     */
    public static String dec05(String encryptedText, String key) {

        int[] stringAlphabetArray = convertToAlphabetIntegerArray(encryptedText);
        int[] keyAlphabetArray = convertToAlphabetIntegerArray(key);
        List<String> numberList = generateNumberList();

        int[] decryptedIntArray = new int[stringAlphabetArray.length];
        String decrypted = "";

        for (int i = 0, j = 0; i < stringAlphabetArray.length; i++) {
            if (stringAlphabetArray[i] > 27) {
                decrypted += decryptDigit(numberList, (char) stringAlphabetArray[i]);
            } else if (stringAlphabetArray[i] < 0) {

                decryptedIntArray[i] = (stringAlphabetArray[i] * -1 - keyAlphabetArray[j]) % 26 - 1;
                if (decryptedIntArray[i] <= 0) {
                    decryptedIntArray[i] += 26;
                }
                decrypted += (char) (decryptedIntArray[i] + 64);
                j = ++j % key.length();
            } else {
                decryptedIntArray[i] = (stringAlphabetArray[i] - keyAlphabetArray[j]) % 26 - 1;
                if (decryptedIntArray[i] <= 0) {
                    decryptedIntArray[i] += 26;
                }
                decrypted += (char) (decryptedIntArray[i] + 96);
                j = ++j % key.length();
            }
        }

        return decrypted;
    }





}
