import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Decrypt {

    public Decrypt(){
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

    public String vigenereDecrypt(String encryptedText, final String key) {
        String decryptedText = "";
        Map<Integer, String> numberStringHashMap = generateNumberEncryptionHashMap();
        for (int i = 0, j = 0; i < encryptedText.length(); i++) {
            char c = encryptedText.charAt(i);
            if (Character.isLowerCase(c)) {
                decryptedText += (char) ((c - key.charAt(j) + 26) % 26 + 'a');
                j = ++j % key.length();
            } else if (Character.isUpperCase(c)) {
                decryptedText += (char) ((c - Character.toUpperCase(key.charAt(j)) + 26) % 26 + 'A');
                j = ++j % key.length();
            } else if (Character.isDigit(c)) {
                decryptedText += decryptDigit(numberStringHashMap, c);
            } else {
                decryptedText += (char) c;

            }
        }
        return decryptedText;
    }

    public String SubstitutionDecrypt(String encryptedText) {
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
    public String AtbashDecrypt(String encryptedText) {
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
    public String generateAtbashOrderedString() {
        String ordered = "";
        for (int i = 32; i <= 126; i++) {
            ordered += (char) i;
        }

        return ordered;
    }
   public String decryptDigitString(String encryptedNumbers) {

        Map<Integer, String> numberStringHashMap = generateNumberEncryptionHashMap();
        String decryptedNumbers = "";
        for (char i : encryptedNumbers.toCharArray()) {
            decryptedNumbers += Character.toString(decryptDigit(numberStringHashMap, i));
        }
        return decryptedNumbers;
    }
    public String CaesarDecrypt(String encrypted, int offset) {

        offset = 26 - offset;

        offset = offset % 26 + 26;
        String decrypted = "";
        Map<Integer, String> numberStringHashMap = generateNumberEncryptionHashMap();
        for (char i : encrypted.toCharArray()) {
            if (Character.isLetter(i)) {
                if (Character.isUpperCase(i)) {
                    decrypted += ((char) ('A' + (i - 'A' + offset) % 26));
                } else {
                    decrypted += ((char) ('a' + (i - 'a' + offset) % 26));
                }
            } else if (Character.isDigit(i)) {
                decrypted += Character.toString(decryptDigit(numberStringHashMap, i));
            } else {
                decrypted += i;
            }
        }
        return decrypted;
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
    public char decryptDigit(Map<Integer, String> numberStringHashMap, char c) {
        if (!Character.isDigit(c)) {
            return c;
        }
        int numericalValue = Character.getNumericValue(c);
        String numberAsString = (String) numberStringHashMap.get(numericalValue);
        boolean needToGetDigit = true;
        char returnDigit = ' ';
        int iterationNumber = 0;
        ArrayList<Integer> keys = new ArrayList<Integer>(numberStringHashMap.keySet());
        while (needToGetDigit) {
            for (int i = keys.size() - 1; i >= 0; i--) {
                if ((keys.get(i) < numericalValue && numberAsString.length() == numberStringHashMap.get(keys.get(i)).length() && iterationNumber == 0) ||
                        (numberStringHashMap.get(keys.get(i)).length() == numberAsString.length() && iterationNumber != 0)) {
                    int encryptedDigit = (int) keys.get(i);
                    returnDigit = (char) (encryptedDigit + '0');
                    needToGetDigit = false;
                    break;
                }
            }
            iterationNumber++;
        }
        return returnDigit;
    }
    public String oneTimePadDecrypt(String encryptedText, String key) {

        int[] stringAlphabetArray = convertToAlphabetIntegerArray(encryptedText);
        int[] keyAlphabetArray = convertToAlphabetIntegerArray(key);
        Map<Integer, String> numberStringHashMap = generateNumberEncryptionHashMap();

        int[] decryptedIntArray = new int[stringAlphabetArray.length];
        String decrypted = "";

        for (int i = 0, j = 0; i < stringAlphabetArray.length; i++) {
            if (stringAlphabetArray[i] > 26) {
                decrypted += decryptDigit(numberStringHashMap, (char) stringAlphabetArray[i]);
            } else if (stringAlphabetArray[i] < 0) {
                decryptedIntArray[i] = (stringAlphabetArray[i] * -1 - keyAlphabetArray[j]) % 26;
                if (decryptedIntArray[i] < 0) {
                    decryptedIntArray[i] += 26;
                }
                decrypted += (char) (decryptedIntArray[i] + 65);
                j = ++j % key.length();
            } else {
                decryptedIntArray[i] = (stringAlphabetArray[i] - keyAlphabetArray[j]) % 26;
                if (decryptedIntArray[i] < 0) {
                    decryptedIntArray[i] += 26;
                }
                decrypted += (char) (decryptedIntArray[i] + 97);
                j = ++j % key.length();
            }
        }

        return decrypted;
    }




}
