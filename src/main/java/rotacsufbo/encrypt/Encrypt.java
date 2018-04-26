package rotacsufbo.encrypt;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Encrypt {

    public static final String KEY = "nrhavqujcmmxmgoelveslhxnfdzabzsqmbmmlrvrmhzriptiaz";

    public Encrypt() {
    }

    public static String encryptAll(String inputText) {
        final int ENCRYPTION_ALGORITHMS = 5;
        //OTP, Vig, Cae, Sub, Atb

        // Determine encryption algorithm to use
        int rngDecider = ThreadLocalRandom.current().nextInt(0, 100); // rng from 0-99
        String rngAppend = rngDecider < 10 ? "0" + rngDecider : rngDecider + ""; //leftpad

        // Actually encrypt the string
        int decision = rngDecider % ENCRYPTION_ALGORITHMS;

        String encrypted = inputText;

//        decision = 2;
        if (decision == 0) {
            // OTP
            encrypted = oneTimePadEncrypt(inputText, "nrhavqujcmmxmgoelveslhxnfdzabzsqmbmmlrvrmhzriptiaz");
            encrypted = rngAppend + encrypted + "nrhavqujcmmxmgoelveslhxnfdzabzsqmbmmlrvrmhzriptiaz";
        } else if (decision == 1) {
            // VIG
            encrypted = vigenereEncrypt(inputText, "dsotfoqmyoowvebrthrnfzssnqiffawblafgspttchidmlhhqi");
            encrypted = rngAppend + encrypted + "dsotfoqmyoowvebrthrnfzssnqiffawblafgspttchidmlhhqi";

        } else if (decision == 2) {
            //SUB
            encrypted = SubstitutionEncrypt(inputText);
            encrypted = rngAppend + encrypted + "sfjlxeamugtqvyvpejybxshpiyyzgmqlhpyzsnemtoyvltacqi";

        } else if (decision == 3) {
            // CAE
            encrypted = CaesarEncrypt(inputText, 10);
            encrypted = rngAppend + encrypted + "edrupzhfsngxeqhfqrcdsatdvlkhasevvqpqwtdzzdouzszdxw";

        } else if (decision == 4) {
            // ATB
            encrypted = AtbashEncrypt(inputText);
            encrypted = rngAppend + encrypted + "ungjiwozgiuejcooxxrpepltrbivsuwkekxtjmqbtmzopsbobl";

        }

        System.out.println("Pre-encoding: " + encrypted);
        //base64 the encrypted string
        String encoded = Base64.getEncoder().encodeToString(encrypted.getBytes());

        System.out.println("Encoded: " + encoded);
        return encoded;
    }

    /**
     * This method encrypts a string using the one time pad technique. This interpretation of the One-Time-Pad
     * method uses a letter in the string and the corresponding letter in the key to be added together. The values
     * added together would be the letters respective positions in the alphabet. For example, a = 1, b = 2.
     * Then it would take the modulus of 26 of their sum to give the position in the alphabet the new encrypted letter should be.
     * For lower case letters, the scale of 1-26 was used. For upper case letters, a negative 1-26 scale was used - e.g. A = -1, B = -2.
     * Numbers and other points of punctuation are not applicable for this method of encryption. For numbers the digit obfuscation technique was used.
     *
     * @param inputText
     * @param key
     * @return encryptedOneTimePadStringx
     */
    public static String oneTimePadEncrypt(String inputText, String key) {

          int[] stringAlphabetArray = convertToAlphabetIntegerArray(inputText);
        int[] keyAlphabetArray = convertToAlphabetIntegerArray(key);

        List<String> numberList = generateNumberList();

        int[] encryptedIntArray = new int[stringAlphabetArray.length];
        String encryptedString = "";
        for (int i = 0, j = 0; i < stringAlphabetArray.length; i++) {
            if (stringAlphabetArray[i] > 26) {
                encryptedString += encryptDigit(numberList, (char) stringAlphabetArray[i]);
            } else if (stringAlphabetArray[i] <= 0) {
                encryptedIntArray[i] = (stringAlphabetArray[i] * -1 + keyAlphabetArray[j]) % 26;
                encryptedString += (char) (encryptedIntArray[i] + 65);
                j = ++j % key.length();
            } else {
                encryptedIntArray[i] = (stringAlphabetArray[i] + keyAlphabetArray[j]) % 26;
                encryptedString += (char) (encryptedIntArray[i] + 97);
                j = ++j % key.length();
            }
        }
        return encryptedString;
    }

    /**
     * This is a novel data encryption / obfuscation technique. Each digit is placed in the list which has a string value that
     * corresponds to their index position. The digit that it would be encrypted to is the next value in the sequence of numbers where the
     * length of the number as a string is the same as the length of the digit you are encrypting as a string. For example, 1 = one would
     * be encrypted to 2 = two. Since two is the next digit higher than one who's word representation is the same length as one. This function has wrap
     * -around capabilities, so for example 8 = eight (which has five letters) would be encrypted to 3 = three, since "three" is the next number with
     * five letters.
     *
     * @param numberList
     * @param digit
     * @return
     */
    public static char encryptDigit(List numberList, char digit) {

        if (!Character.isDigit(digit)) {
            return digit;
        }
        int numericalValue = Character.getNumericValue(digit);

        String numberAsString = (String) numberList.get(numericalValue);
        boolean needToGetDigit = true;
        char returnDigit = ' ';
        int iterationNumber = 0;
        while (needToGetDigit) {
            for (int i = 0; i < numberList.size(); i++) {
                String value = (String) numberList.get(i);
                if ((value.length() == numberAsString.length() && i > numericalValue && iterationNumber == 0) ||
                        (value.length() == numberAsString.length() && iterationNumber != 0)) {
                    int encryptedDigit = i;
                    returnDigit = (char) (encryptedDigit + '0');
                    needToGetDigit = false;
                    break;
                }
            }
            iterationNumber++;
        }
        return returnDigit;
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
     * Converts the letters to the corresponding position on the alphabet a = 1, b = 2 ...
     * If it is not a letter, then it would be their value in the ASCII representation.
     *
     * @param text
     * @return an integer array of alphabet positions.
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
                    alphabetArray[i] = ((int) c - 'a' + 1);
                }
            }
            i++;
        }
        return alphabetArray;
    }

    /**
     * This type of cipher technique uses the key as each letter corresponds to the letter position in the string.
     * Once the key word has used its last letter it would wrap around again. This technique is not applicable to numbers and punctuation.
     * Hence, the novel number obfuscation technique was used for digits and no difference for punctuation.
     * @param inputText
     * @param key
     * @return
     */
    public static String vigenereEncrypt(String inputText, String key) {
        String encrypted = "";
        List<String> numberList = generateNumberList();
        for (int i = 0, j = 0; i < inputText.length(); i++) {
            char c = inputText.charAt(i);
            if (Character.isLowerCase(c)) {
                encrypted += (char) ((c + key.charAt(j) - 2 * 'a') % 26 + 'a');
                j = ++j % key.length();
            } else if (Character.isUpperCase(c)) {
                encrypted += (char) ((c + Character.toUpperCase(key.charAt(j)) - 2 * 'A') % 26 + 'A');
                j = ++j % key.length();
            } else if (Character.isDigit(c)) {
                encrypted += Character.toString(encryptDigit(numberList, c));
            } else {
                encrypted += (char) c;
            }
        }
        return encrypted;
    }

    /**
     * This cipher technique shifts the ASCII value of a character by a certain offset and becomes with another letter
     * in the alphabet. Likewise, this is only applicable for letters - uppercase and lower case. FOr digits the novel
     * digit obfuscation technique was used and for punctuation there was no significant difference.
     * @param enc
     * @param offset
     * @return
     */
    public static String CaesarEncrypt(String enc, int offset) {
        offset = offset % 26 + 26;
        String encrypted = "";
        List<String> numberList = generateNumberList();
        for (char i : enc.toCharArray()) {
            if (Character.isLetter(i)) {
                if (Character.isUpperCase(i)) {
                    encrypted += ((char) ('A' + (i - 'A' + offset) % 26));
                } else {
                    encrypted += ((char) ('a' + (i - 'a' + offset) % 26));
                }
            } else if (Character.isDigit(i)) {
                encrypted += Character.toString(encryptDigit(numberList, i));
            } else {
                encrypted += i;
            }
        }
        return encrypted;
    }

    /**
     * This encryption technique takes all applicable ASCII characters (numbers, letters and punctuation) into account.
     * It shifts them by a constant amount (69). If the addition from the current value + 69 exceeds the highest applicable
     * ASCII integer value then it would do a wrap around.
     * @param inputText
     * @return
     */
    public static String SubstitutionEncrypt(String inputText) {
        String encrypted = "";
        for (char c : inputText.toCharArray()) {
            int newIntegerValue = (int) c + 69;
            if (newIntegerValue > 126) {
                int offset = newIntegerValue - 126;
                newIntegerValue = 32 + offset - 1;
            }
            encrypted += (char) newIntegerValue;
        }

        return encrypted;
    }

    /**
     * This encryption technique takes a string of characters (in this case all ASCII characters applicable with numbers, letters and punctuation).
     * It chooses the character to encrypt it with by reversing the string of characters and identifying the character in the corresponding
     * position of the reversed string.
     * @param inputText
     * @return
     */
    public static String AtbashEncrypt(String inputText) {
        String ordered = generateAtbashOrderedString();
        StringBuffer buffer = new StringBuffer(ordered);
        String reverse = buffer.reverse().toString();
        String encryptedString = "";

        for (int i = 0; i < inputText.length(); i++) {
            char currentCharacter = inputText.charAt(i);
            int indexOfCurrentCharacter = ordered.indexOf(currentCharacter);
            encryptedString += reverse.charAt(indexOfCurrentCharacter);
        }

        return encryptedString;
    }

    /**
     * Iterating through applicable ASCII integer values to obtain the character and concatenate it to the string of characters used.
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
     * Uses a string input based on the assumption that it is only complete with numbers. Then it would encrypt each individual digit with
     * the novel number encryption technique.
     * @param numbers
     * @return
     */
    public static String encryptDigitString(String numbers) {

        List<String> numberList = generateNumberList();
        String encryptedNumbers = "";
        for (char i : numbers.toCharArray()) {
            encryptedNumbers += Character.toString(encryptDigit(numberList, i));
        }
        return encryptedNumbers;
    }
}
