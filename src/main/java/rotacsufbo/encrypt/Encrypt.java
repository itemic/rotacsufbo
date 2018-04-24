package rotacsufbo.encrypt;

import java.util.Map;
import java.util.TreeMap;

public class Encrypt {


    public Encrypt(){
    }

    /**
     * This method encrypts a string using the one time pad technique. This interpretation of the One-Time-Pad
     * method uses a letter in the string and the corresponding letter in the key to be added together. The values
     * added together would be the letters respective positions in the alphabet. For example, a = 1, b = 2.
     * Then it would take the modulus of 26 of their sum to give the position in the alphabet the new encrypted letter should be.
     * For lower case letters, the scale of 1-26 was used. For upper case letters, a negative 1-26 scale was used - e.g. A = -1, B = -2.
     * Numbers and other points of punctuation are not applicable for this method of encryption. For numbers the digit obfuscation technique was used.
     * @param inputText
     * @param key
     * @return encryptedOneTimePadStringx
     */
    public String oneTimePadEncrypt(String inputText, String key) {

        int[] stringAlphabetArray = convertToAlphabetIntegerArray(inputText);
        int[] keyAlphabetArray = convertToAlphabetIntegerArray(key);

        Map<Integer, String> numberStringHashMap = generateNumberEncryptionHashMap();

        int[] encryptedIntArray = new int[stringAlphabetArray.length];
        String encryptedString = "";
        for (int i = 0, j = 0; i < stringAlphabetArray.length; i++) {
            if (stringAlphabetArray[i] > 26) {
                encryptedString += encryptDigit(numberStringHashMap, (char) stringAlphabetArray[i]);
            } else if (stringAlphabetArray[i] < 0) {
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
     * This is a novel data encryption / obfuscation techniqeue. Each digit is placed in the hashmap which has a string value that
     * corresponds to their name (1 = "one"). The digit that it would be encrypted to is the next value in the sequence of numbers where the
     * length of the number as a string is the same as the length of the digit you are encrypting as a string. For example, 1 = one would
     * be encrypted to 2 = two. Since two is the next digit higher than one who's word representation is the same length as one. This function has wrap
     * -around capabilities, so for example 8 = eight (which has five letters) would be encrypted to 3 = three, since "three" is the next number with
     * five letter.
     * @param numberStringHashMap
     * @param digit
     * @return
     */
    public char encryptDigit(Map numberStringHashMap, char digit) {

        if (!Character.isDigit(digit)) {
            return digit;
        }
        int numericalValue = Character.getNumericValue(digit);

        String numberAsString = (String) numberStringHashMap.get(numericalValue);
        boolean needToGetDigit = true;
        char returnDigit = ' ';
        int iterationNumber = 0;
        while (needToGetDigit) {
            for (Object key : numberStringHashMap.keySet()) {
                String value = (String) numberStringHashMap.get(key);
                if ((value.length() == numberAsString.length() && (int) key > numericalValue && iterationNumber == 0) ||
                        (value.length() == numberAsString.length() && iterationNumber != 0)) {
                    int encryptedDigit = (int) key;
                    returnDigit = (char) (encryptedDigit + '0');
                    needToGetDigit = false;
                    break;
                }
            }
            iterationNumber++;
        }

        return returnDigit;
    }

    public Map generateNumberEncryptionHashMap() {
        Map<Integer, String> numberStringHashMap = new TreeMap<Integer, String>();
        numberStringHashMap.put(0, "zero");
        numberStringHashMap.put(1, "one");
        numberStringHashMap.put(2, "two");
        numberStringHashMap.put(3, "three");
        numberStringHashMap.put(4, "four");
        numberStringHashMap.put(5, "five");
        numberStringHashMap.put(6, "six");
        numberStringHashMap.put(7, "seven");
        numberStringHashMap.put(8, "eight");
        numberStringHashMap.put(9, "nine");

        return numberStringHashMap;

    }

    /* Converts the letters to the corresponding position on the alphabet a = 1, b = 2 ...*/
    public int[] convertToAlphabetIntegerArray(String text) {
        int[] alphabetArray = new int[text.length()];
        int i = 0;

        for (char c : text.toCharArray()) {
            if (!Character.isLetter(c)) {
                alphabetArray[i] = (int) c;
            } else {
                if (Character.isUpperCase(c)) {
                    alphabetArray[i] = ((int) c - 'A') * -1;
                } else {
                    alphabetArray[i] = (int) c - 'a';
                }

            }
            i++;
        }
        return alphabetArray;
    }

    public String vigenereEncrypt(String inputText, String key) {
        String encrypted = "";
        Map<Integer, String> numberStringHashMap = generateNumberEncryptionHashMap();
        for (int i = 0, j = 0; i < inputText.length(); i++) {
            char c = inputText.charAt(i);
            if (Character.isLowerCase(c)) {
                encrypted += (char) ((c + key.charAt(j) - 2 * 'a') % 26 + 'a');
                j = ++j % key.length();
            } else if (Character.isUpperCase(c)) {
                encrypted += (char) ((c + Character.toUpperCase(key.charAt(j)) - 2 * 'A') % 26 + 'A');
                j = ++j % key.length();
            } else if (Character.isDigit(c)) {
                encrypted += Character.toString(encryptDigit(numberStringHashMap, c));
            } else {
                encrypted += (char) c;
            }
        }
        return encrypted;
    }

    public String CaesarEncrypt(String enc, int offset) {
        offset = offset % 26 + 26;
        String encrypted = "";
        Map<Integer, String> numberStringHashMap = generateNumberEncryptionHashMap();
        for (char i : enc.toCharArray()) {
            if (Character.isLetter(i)) {
                if (Character.isUpperCase(i)) {
                    encrypted += ((char) ('A' + (i - 'A' + offset) % 26));
                } else {
                    encrypted += ((char) ('a' + (i - 'a' + offset) % 26));
                }
            } else if (Character.isDigit(i)) {
                    encrypted += Character.toString(encryptDigit(numberStringHashMap, i));
            } else {
                encrypted += i;
            }
        }
        return encrypted;
    }

    public String SubstitutionEncrypt(String inputText) {
        String sb = "";
        for (char c : inputText.toCharArray()) {
            int newIntegerValue = (int) c + 69;
            if (newIntegerValue > 126) {
                int offset = newIntegerValue - 126;
                newIntegerValue = 32 + offset - 1;
            }
            sb += (char) newIntegerValue;
        }

        return sb;
    }

    public String AtbashEncrypt(String inputText) {
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
    public String generateAtbashOrderedString() {
        String ordered = "";
        for (int i = 32; i <= 126; i++) {
            ordered += (char) i;
        }

        return ordered;
    }
    public String encryptDigitString(String numbers) {

        Map<Integer, String> numberStringHashMap = generateNumberEncryptionHashMap();
        String encryptedNumbers = "";
        for (char i : numbers.toCharArray()) {
            encryptedNumbers += Character.toString(encryptDigit(numberStringHashMap, i));
        }
        return encryptedNumbers;
    }


}
