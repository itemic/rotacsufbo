package rotacsufbo.encrypt;

import java.util.*;

public class Decrypt {

    public static String decrypt(String encrypted) {
        int ENCRYPTION_ALGORITHMS = 0;
        byte[] decoded = null;
        String decodedStr = null;
        int encryptorUsed = 0;
        String decryptedString = null;
        String key = null;
        String switchOnThis = "০ⲟ໐๐ℴ౦ｏօዐℴ૦౦ｏዐℴо੦๐ዐ০೦๐օዐ੦੦ჿ೦૦၀૦ჿｏ၀ⲟօ";
        boolean infiniteLoop = true;
        int[] OPAQUES = new int[] { 642, 68, 306, 635, 117, 467, 383, 362, 621, 586, 117, 642, 607, 649, 495, 628, 201, 544, 579, 348, 7, 5, 7, 5 };
        while (infiniteLoop) {
            switch(switchOnThis) {
                case "၀օ੦ჿ௦ჿ೦၀ዐо၀๐০ዐℴჿ೦〇ዐ০௦〇оዐ໐੦૦౦о౦ⲟ௦೦೦໐ჿ":
                    System.out.println("Decrypted: " + decryptedString);
                    switchOnThis = "໐၀оⲟ໐օ〇ჿዐ〇၀၀၀ዐℴ૦૦ℴዐօ೦੦໐ዐ௦ℴօ০௦૦оℴｏｏ๐໐";
                    break;
                case "ℴ၀ჿｏｏⲟℴ౦ዐⲟℴℴ၀ዐℴ๐౦оዐ০০օ〇ዐ၀օ๐օჿℴ೦〇౦ｏ〇ｏ":
                    if (OPAQUES[1] % OPAQUES[22] == OPAQUES[23]) {
                        System.out.println("Decrypted: " + decryptedString);
                        switchOnThis = "օ〇໐০ℴℴჿ௦ዐ౦০оჿዐℴ౦၀ℴዐ૦ჿ๐ⲟዐⲟⲟ೦౦૦о౦੦о໐ｏ〇";
                    } else {
                        key = decodedStr.substring(decodedStr.length() - 50);
                        switchOnThis = "০๐၀օо໐〇๐ዐჿօｏ๐ዐℴ૦๐૦ዐ੦օоⲟዐჿ௦೦০໐ⲟ౦๐౦ｏ၀օ";
                    }
                    break;
                case "੦੦о၀〇০օօዐ౦೦௦၀ዐℴ০੦૦ዐօ૦օ๐ዐ໐оօо၀၀օ০০௦၀օ":
                    if (OPAQUES[18] % OPAQUES[20] != OPAQUES[21]) {
                        System.out.println("Decrypted: " + decryptedString);
                        switchOnThis = "օℴ๐о௦౦օօዐ〇౦ｏ০ዐℴ௦౦ჿዐ੦໐ჿⲟዐ೦၀ℴ೦ℴօօ၀০౦๐๐";
                    } else {
                        decryptedString = decodedStr.substring(2, decodedStr.length() - 50);
                        switchOnThis = "ℴ௦ჿｏ௦ℴօჿዐ૦ℴ〇೦ዐℴ੦૦੦ዐ૦ℴｏоዐօ๐๐о௦ჿ๐೦௦ℴ০ⲟ";
                    }
                    break;
                case "੦၀໐௦၀о၀оዐℴ๐๐๐ዐℴ੦ⲟ০ዐօо၀௦ዐℴℴ໐੦ⲟჿ〇оօჿⲟｏ":
                    ENCRYPTION_ALGORITHMS = 5;
                    switchOnThis = "၀〇௦০ⲟ౦౦〇ዐℴ೦о๐ዐℴ໐๐ჿዐ੦၀໐оዐｏ๐೦〇оօ๐օℴｏ௦೦";
                    break;
                case "оօℴℴօℴჿℴዐ੦〇ℴ၀ዐℴ০օ੦ዐ੦೦೦౦ዐｏ૦〇০〇о೦ჿ౦၀ｏ๐":
                    encryptorUsed = 10 * Character.getNumericValue(decodedStr.charAt(0)) + Character.getNumericValue(decodedStr.charAt(1));
                    switchOnThis = "০໐๐օ〇૦ｏჿዐ೦૦ⲟ૦ዐℴℴ੦௦ዐ০〇၀๐ዐⲟ౦оｏ০໐ｏჿⲟ೦ჿ೦";
                    break;
                case "၀౦௦ℴ૦оｏ੦ዐ௦օ౦೦ዐℴօ၀௦ዐ੦๐০ჿዐ௦૦໐ჿ๐ჿჿ๐ｏ૦੦ℴ":
                    System.out.println("Decrypted: " + decryptedString);
                    switchOnThis = "౦໐૦໐ჿℴօｏዐ௦ჿ๐૦ዐℴ๐໐௦ዐ૦о০০ዐоｏჿჿооⲟ੦০〇ℴ೦";
                    break;
                case "ℴⲟ೦੦〇ჿ௦ℴዐ੦оｏ〇ዐℴℴ௦౦ዐօｏ೦ℴዐ௦օｏ೦օ၀ｏ੦০๐೦о":
                    if (OPAQUES[0] % OPAQUES[20] == OPAQUES[21]) {
                        if (encryptorUsed == 0) {
                            // OTP
                            decryptedString = dec05(decryptedString, key);
                        } else if (encryptorUsed == 1) {
                            // VIG
                            decryptedString = dec01(decryptedString, key);
                        } else if (encryptorUsed == 2) {
                            // SUB
                            decryptedString = dec02(decryptedString, key);
                        } else if (encryptorUsed == 3) {
                            // CAE
                            decryptedString = dec03(decryptedString, 10);
                        } else if (encryptorUsed == 4) {
                            // ATB
                            decryptedString = dec04(decryptedString, key);
                        }
                        switchOnThis = "ℴ၀ჿｏｏⲟℴ౦ዐⲟℴℴ၀ዐℴ๐౦оዐ০০օ〇ዐ၀օ๐օჿℴ೦〇౦ｏ〇ｏ";
                    } else {
                        key = decodedStr.substring(decodedStr.length() - 50);
                        switchOnThis = "੦໐၀〇о〇ჿоዐ೦ｏ০ⲟዐℴⲟօ೦ዐ૦໐၀૦ዐ໐౦ｏ௦౦ⲟჿоօօօ০";
                    }
                    break;
                case "၀௦੦೦ℴ၀၀օዐ౦๐ჿ๐ዐℴ〇౦೦ዐօｏ၀౦ዐｏℴჿ௦໐ℴ໐ⲟ๐օჿ౦":
                    if (OPAQUES[12] % OPAQUES[20] == OPAQUES[21]) {
                        decoded = Base64.getDecoder().decode(encrypted);
                        switchOnThis = "໐੦০၀ооօ౦ዐｏ੦০๐ዐℴօ౦၀ዐ૦๐০૦ዐ੦օ౦ჿ౦օ௦໐ჿჿｏ௦";
                    } else {
                        encryptorUsed = 10 * Character.getNumericValue(decodedStr.charAt(0)) + Character.getNumericValue(decodedStr.charAt(1));
                        switchOnThis = "૦໐ⲟｏ૦ჿ၀ℴዐ၀౦၀೦ዐℴⲟ೦໐ዐ੦೦੦〇ዐⲟ૦ⲟ〇౦০๐০๐౦၀ℴ";
                    }
                    break;
                case "௦੦๐о〇௦๐໐ዐ௦၀૦௦ዐℴо૦၀ዐ০੦ｏჿዐ০օｏ੦ⲟ௦೦ჿ০ⲟօ౦":
                    if (OPAQUES[2] % OPAQUES[20] == OPAQUES[21]) {
                        encryptorUsed %= ENCRYPTION_ALGORITHMS;
                        switchOnThis = "੦੦о၀〇০օօዐ౦೦௦၀ዐℴ০੦૦ዐօ૦օ๐ዐ໐оօо၀၀օ০০௦၀օ";
                    } else {
                        decryptedString = decodedStr.substring(2, decodedStr.length() - 50);
                        switchOnThis = "ჿ੦೦೦о௦০๐ዐｏ໐օ૦ዐℴℴჿⲟዐօჿ၀၀ዐ๐օ೦໐੦০оⲟ౦ⲟ০੦";
                    }
                    break;
                case "੦௦౦ⲟ০〇о೦ዐｏ〇๐оዐℴ૦๐〇ዐօ੦૦၀ዐօ໐၀ⲟ੦၀ｏℴⲟ๐০੦":
                    return decryptedString;
                case "০ⲟ໐๐ℴ౦ｏօዐℴ૦౦ｏዐℴо੦๐ዐ০೦๐օዐ੦੦ჿ೦૦၀૦ჿｏ၀ⲟօ":
                    if (OPAQUES[11] % OPAQUES[22] != OPAQUES[23]) {
                        return decryptedString;
                        switchOnThis = "๐ℴ〇੦ჿ૦௦௦ዐ໐০੦၀ዐℴჿ໐၀ዐ০၀௦ⲟዐ〇೦၀〇೦ⲟ੦ჿⲟ໐ℴ〇";
                    } else {
                        ENCRYPTION_ALGORITHMS = 5;
                        switchOnThis = "၀௦੦೦ℴ၀၀օዐ౦๐ჿ๐ዐℴ〇౦೦ዐօｏ၀౦ዐｏℴჿ௦໐ℴ໐ⲟ๐օჿ౦";
                    }
                    break;
                case "ℴ೦օ০оｏｏоዐ૦〇੦၀ዐℴ০๐௦ዐօ೦ჿｏዐ೦೦օ໐ჿｏօｏ౦౦օօ":
                    if (OPAQUES[18] % OPAQUES[20] != OPAQUES[21]) {
                        decodedStr = new String(decoded);
                        switchOnThis = "๐ｏ০ℴ૦௦ⲟ૦ዐ০໐ℴℴዐℴ૦၀ｏዐ૦೦໐оዐ໐૦౦૦ⲟ〇౦ⲟ੦๐๐〇";
                    } else {
                        encryptorUsed = 10 * Character.getNumericValue(decodedStr.charAt(0)) + Character.getNumericValue(decodedStr.charAt(1));
                        switchOnThis = "௦੦๐о〇௦๐໐ዐ௦၀૦௦ዐℴо૦၀ዐ০੦ｏჿዐ০օｏ੦ⲟ௦೦ჿ০ⲟօ౦";
                    }
                    break;
                case "໐੦০၀ооօ౦ዐｏ੦০๐ዐℴօ౦၀ዐ૦๐০૦ዐ੦օ౦ჿ౦օ௦໐ჿჿｏ௦":
                    if (OPAQUES[18] % OPAQUES[20] == OPAQUES[21]) {
                        decodedStr = new String(decoded);
                        switchOnThis = "ℴ೦օ০оｏｏоዐ૦〇੦၀ዐℴ০๐௦ዐօ೦ჿｏዐ೦೦օ໐ჿｏօｏ౦౦օօ";
                    } else {
                        encryptorUsed = 10 * Character.getNumericValue(decodedStr.charAt(0)) + Character.getNumericValue(decodedStr.charAt(1));
                        switchOnThis = "ооօჿ౦ℴ੦๐ዐ๐੦օօዐℴ০੦౦ዐօ௦օ๐ዐ๐၀օ໐၀੦০๐ℴ૦ℴ੦";
                    }
                    break;
                case "ℴ௦ჿｏ௦ℴօჿዐ૦ℴ〇೦ዐℴ੦૦੦ዐ૦ℴｏоዐօ๐๐о௦ჿ๐೦௦ℴ০ⲟ":
                    if (OPAQUES[19] % OPAQUES[22] != OPAQUES[23]) {
                        decoded = Base64.getDecoder().decode(encrypted);
                        switchOnThis = "০໐ｏ೦০ｏ၀০ዐօ〇૦ⲟዐℴ౦о೦ዐօ੦оჿዐ੦૦੦໐၀໐௦໐੦о౦౦";
                    } else {
                        key = decodedStr.substring(decodedStr.length() - 50);
                        switchOnThis = "ℴⲟ೦੦〇ჿ௦ℴዐ੦оｏ〇ዐℴℴ௦౦ዐօｏ೦ℴዐ௦օｏ೦օ၀ｏ੦০๐೦о";
                    }
                    break;
                case "ｏ೦໐౦০໐ⲟ๐ዐօ໐၀੦ዐℴоⲟｏዐօоℴ౦ዐօ๐ℴоⲟⲟჿ೦໐ჿ〇౦":
                    return decryptedString;
                case "ℴօჿ೦೦ჿ௦ℴዐ০ｏ௦օዐℴ〇੦೦ዐօჿ௦໐ዐо〇ｏ໐ℴℴ౦௦ℴ౦೦о":
                    encryptorUsed = 10 * Character.getNumericValue(decodedStr.charAt(0)) + Character.getNumericValue(decodedStr.charAt(1));
                    switchOnThis = "໐၀০௦ⲟ೦౦૦ዐ੦о೦૦ዐℴ০੦оዐ૦૦၀೦ዐ〇๐ｏ〇о๐૦૦ჿ০૦օ";
                    break;
                case "૦০૦ｏ౦๐௦ⲟዐｏоօоዐℴ০౦〇ዐ૦௦ჿℴዐℴ૦օ೦〇௦օоｏ໐ჿⲟ":
                    if (encryptorUsed == 0) {
                        // OTP
                        decryptedString = dec05(decryptedString, key);
                    } else if (encryptorUsed == 1) {
                        // VIG
                        decryptedString = dec01(decryptedString, key);
                    } else if (encryptorUsed == 2) {
                        // SUB
                        decryptedString = dec02(decryptedString, key);
                    } else if (encryptorUsed == 3) {
                        // CAE
                        decryptedString = dec03(decryptedString, 10);
                    } else if (encryptorUsed == 4) {
                        // ATB
                        decryptedString = dec04(decryptedString, key);
                    }
                    switchOnThis = "օ౦օ૦ℴｏｏ௦ዐ೦ჿоｏዐℴօ૦оዐ০ⲟ੦ｏዐоօ〇૦օ૦๐๐օ੦ℴ௦";
                    break;
                case "௦օ౦౦о౦၀ⲟዐ౦੦ჿօዐℴ౦〇ⲟዐ০ⲟ௦ⲟዐ௦օ੦੦೦ｏ௦௦၀ჿ၀੦":
                    System.out.println("Decrypted: " + decryptedString);
                    switchOnThis = "೦૦օ໐௦၀೦ｏዐо၀೦ｏዐℴⲟ໐〇ዐ੦၀௦૦ዐ০௦૦օоօ౦ｏⲟ၀૦੦";
                    break;
                case "օ〇໐০ℴℴჿ௦ዐ౦০оჿዐℴ౦၀ℴዐ૦ჿ๐ⲟዐⲟⲟ೦౦૦о౦੦о໐ｏ〇":
                    if (OPAQUES[17] % OPAQUES[22] != OPAQUES[23]) {
                        ENCRYPTION_ALGORITHMS = 5;
                        switchOnThis = "၀௦๐০၀ⲟ໐๐ዐ๐о౦၀ዐℴℴ೦০ዐ০ⲟ੦০ዐо௦ℴ೦ℴ০օ೦о੦ｏо";
                    } else {
                        return decryptedString;
                        switchOnThis = "૦၀౦౦౦೦੦০ዐⲟо๐օዐℴჿ੦〇ዐ૦੦౦ⲟዐօ໐օ௦ℴ౦〇໐〇၀о໐";
                    }
                case "օ౦০๐ⲟ၀ℴ๐ዐ௦ｏ౦ℴዐℴ೦ⲟ౦ዐօ੦০੦ዐ૦௦੦о๐ℴⲟ੦౦੦၀〇":
                    if (encryptorUsed == 0) {
                        // OTP
                        decryptedString = dec05(decryptedString, key);
                    } else if (encryptorUsed == 1) {
                        // VIG
                        decryptedString = dec01(decryptedString, key);
                    } else if (encryptorUsed == 2) {
                        // SUB
                        decryptedString = dec02(decryptedString, key);
                    } else if (encryptorUsed == 3) {
                        // CAE
                        decryptedString = dec03(decryptedString, 10);
                    } else if (encryptorUsed == 4) {
                        // ATB
                        decryptedString = dec04(decryptedString, key);
                    }
                    switchOnThis = "ｏℴоｏ๐੦૦օዐჿ૦௦ჿዐℴо૦ჿዐօ੦০௦ዐჿｏօ০೦ℴ๐౦௦౦০૦";
                    break;
                default:
                    infiniteLoop = false;
            }
        }
        return null;
    }

    /**
     * Generating a list where each number corresponds to its position in the list.
     *
     * @return
     */
    public static List generateNumberList() {
        List<String> places = null;
        String switchOnThis = "ⲟ๐૦օ೦օ〇օዐ೦ჿჿ၀ዐℴ๐ℴ౦ዐ૦〇௦၀ዐჿ੦၀о〇੦ჿ〇ℴ૦ℴჿ";
        boolean infiniteLoop = true;
        int[] OPAQUES = new int[] { 201, 33, 579, 68, 600, 628, 117, 600, 257, 124, 208, 488, 222, 131, 152, 649, 173, 26, 166, 313, 7, 5, 7, 5 };
        while (infiniteLoop) {
            switch(switchOnThis) {
                case "〇ℴℴ೦௦໐ჿօዐ໐ჿ၀౦ዐℴ೦๐೦ዐօ೦౦ⲟዐ౦օо၀๐օ০ჿｏ໐૦௦":
                    return places;
                case "ⲟ๐૦օ೦օ〇օዐ೦ჿჿ၀ዐℴ๐ℴ౦ዐ૦〇௦၀ዐჿ੦၀о〇੦ჿ〇ℴ૦ℴჿ":
                    if (OPAQUES[13] % OPAQUES[22] != OPAQUES[23]) {
                        places = Arrays.asList("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
                        switchOnThis = "ℴ〇о〇๐໐ｏⲟዐ૦о໐၀ዐℴⲟ๐௦ዐ০೦໐౦ዐ૦ⲟ౦๐〇๐ⲟჿｏⲟо౦";
                    } else {
                        places = Arrays.asList("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
                        switchOnThis = "ჿ੦оо০೦੦ｏዐо০௦ჿዐℴ੦੦০ዐօ౦੦૦ዐ〇〇౦о๐၀੦၀ℴ໐ჿ໐";
                    }
                    break;
                case "౦〇೦๐০౦௦оዐⲟ๐੦๐ዐℴ〇օ၀ዐ০օ௦০ዐ૦໐๐௦ｏჿ૦੦௦〇օ〇":
                    places = Arrays.asList("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
                    switchOnThis = "ｏ၀௦௦๐໐о໐ዐ౦օ౦ｏዐℴ০ჿ໐ዐօ၀౦૦ዐｏℴჿօ೦௦օ၀૦о๐о";
                    break;
                case "ჿ੦оо০೦੦ｏዐо০௦ჿዐℴ੦੦০ዐօ౦੦૦ዐ〇〇౦о๐၀੦၀ℴ໐ჿ໐":
                    if (OPAQUES[18] % OPAQUES[20] != OPAQUES[21]) {
                        return places;
                        switchOnThis = "օоｏ০০օ๐〇ዐ၀০ⲟ૦ዐℴ೦〇ℴዐ੦〇ჿօዐօоо၀о০ｏ〇ⲟ೦೦૦";
                    } else {
                        return places;
                        switchOnThis = "օօⲟ௦೦၀੦໐ዐ၀০օ੦ዐℴⲟ૦оዐ੦০೦౦ዐ೦ｏ౦օℴჿ௦ｏⲟ໐௦௦";
                    }
                default:
                    infiniteLoop = false;
            }
        }
        return null;
    }

    /**
     * This is the decryption method for the Vigenere cipher technique. It would decrypt letters that followed this encryption method, but
     * numbers was decrypted by the other digit encryption technique and punctuation was left as is.
     * @param encryptedText
     * @param key
     * @return
     */
    public static String dec01(String encryptedText, final String key) {
        String decryptedText = null;
        List<String> numberList = null;
        String switchOnThis = "੦೦ⲟ੦໐ℴჿ౦ዐｏℴ౦оዐℴ૦౦օዐ০০০૦ዐ০૦੦௦૦໐оℴ๐〇ｏ০";
        boolean infiniteLoop = true;
        int[] OPAQUES = new int[] { 369, 68, 425, 495, 516, 362, 12, 215, 439, 40, 215, 446, 117, 593, 299, 649, 404, 628, 621, 173, 7, 5, 7, 5 };
        while (infiniteLoop) {
            switch(switchOnThis) {
                case "੦๐೦໐๐о໐౦ዐօ೦၀ჿዐℴℴ๐০ዐ০૦о౦ዐ၀օ๐೦ჿ໐ჿо౦೦௦օ":
                    return decryptedText;
                case "ℴо၀૦оⲟ၀੦ዐℴℴჿ໐ዐℴჿℴ๐ዐ੦๐〇〇ዐ০౦օ๐ｏօ౦ჿօ੦օ੦":
                    if (OPAQUES[11] % OPAQUES[22] != OPAQUES[23]) {
                        decryptedText = "";
                        switchOnThis = "௦০๐ｏ၀๐ℴ੦ዐօօ౦੦ዐℴ〇੦оዐ੦၀০၀ዐ੦๐ⲟ೦о౦௦ℴｏ〇၀০";
                    } else {
                        return decryptedText;
                        switchOnThis = "০০օℴ౦೦౦ｏዐ၀๐ооዐℴ૦〇౦ዐ੦օ๐၀ዐ੦౦ⲟ૦๐၀੦ⲟ੦ჿ૦〇";
                    }
                case "๐౦ჿⲟ০૦০ჿዐⲟ〇౦੦ዐℴօ〇〇ዐ੦〇၀ℴዐｏⲟ੦ℴօℴоℴ੦օⲟ೦":
                    decryptedText = "";
                    switchOnThis = "ჿℴ੦໐〇ｏ〇〇ዐ౦௦੦೦ዐℴ೦〇૦ዐօ౦๐օዐ〇ℴ౦〇๐ｏჿ௦໐০ჿօ";
                    break;
                case "о၀೦ｏ໐๐ⲟ౦ዐｏօｏｏዐℴ੦၀૦ዐ০ⲟօ০ዐо၀〇ჿ౦૦౦ჿℴ૦໐০":
                    if (OPAQUES[16] % OPAQUES[20] == OPAQUES[21]) {
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
                        switchOnThis = "ℴо၀૦оⲟ၀੦ዐℴℴჿ໐ዐℴჿℴ๐ዐ੦๐〇〇ዐ০౦օ๐ｏօ౦ჿօ੦օ੦";
                    } else {
                        return decryptedText;
                        switchOnThis = "ｏօｏჿ੦оօｏዐ০໐〇ℴዐℴ౦ⲟⲟዐ০૦০ℴዐоо๐০օօ೦օ௦໐၀೦";
                    }
                    break;
                case "〇౦೦ⲟ೦օ௦೦ዐ০〇೦๐ዐℴ௦оℴዐ੦၀೦оዐℴо౦〇ჿ๐౦౦ℴⲟ౦о":
                    decryptedText = "";
                    switchOnThis = "〇౦ჿℴℴ౦ⲟ০ዐ๐௦੦ｏዐℴ೦૦ⲟዐօ〇౦೦ዐｏо๐ｏ၀০௦〇օ౦೦ℴ";
                    break;
                case "૦ჿօ๐〇০ⲟ০ዐօ೦౦๐ዐℴ၀օ〇ዐօⲟ〇౦ዐ໐оℴⲟ০օⲟ০๐๐౦০":
                    return decryptedText;
                case "၀ⲟ໐೦૦๐ჿ੦ዐ೦ℴჿჿዐℴℴ๐၀ዐօ০о૦ዐ੦ⲟჿօ০๐૦೦ｏ๐໐௦":
                    if (OPAQUES[8] % OPAQUES[20] != OPAQUES[21]) {
                        numberList = generateNumberList();
                        switchOnThis = "೦၀о૦ⲟ೦੦၀ዐ௦ჿ০ჿዐℴⲟⲟ૦ዐօ౦оჿዐｏ೦ⲟ೦၀੦૦ℴ੦໐૦〇";
                    } else {
                        numberList = generateNumberList();
                        switchOnThis = "о၀೦ｏ໐๐ⲟ౦ዐｏօｏｏዐℴ੦၀૦ዐ০ⲟօ০ዐо၀〇ჿ౦૦౦ჿℴ૦໐০";
                    }
                    break;
                case "੦೦ⲟ੦໐ℴჿ౦ዐｏℴ౦оዐℴ૦౦օዐ০০০૦ዐ০૦੦௦૦໐оℴ๐〇ｏ০":
                    if (OPAQUES[14] % OPAQUES[20] == OPAQUES[21]) {
                        decryptedText = "";
                        switchOnThis = "၀ⲟ໐೦૦๐ჿ੦ዐ೦ℴჿჿዐℴℴ๐၀ዐօ০о૦ዐ੦ⲟჿօ০๐૦೦ｏ๐໐௦";
                    } else {
                        return decryptedText;
                        switchOnThis = "ჿ੦оⲟ၀૦੦оዐօ೦০౦ዐℴⲟ౦੦ዐ૦౦௦০ዐ๐၀၀೦ⲟ૦໐໐௦໐౦௦";
                    }
                    break;
                default:
                    infiniteLoop = false;
            }
        }
        return null;
    }

    /**
     * This decryption takes care of the Substitution encryption technique. If the predetermined offset provides an ASCII value
     * which is less than 32 (the lowest acceptable ASCII value for characters relevant), it would wrap around and proceed through the
     * higher ASCII values.
     * @param encryptedText
     * @return
     */
    public static String dec02(String encryptedText, String key) {
        String decryptedString = null;
        String switchOnThis = "௦оо০ℴօ૦౦ዐ໐໐〇০ዐℴ໐၀໐ዐ੦ｏ๐၀ዐ੦௦ｏⲟჿｏ௦೦օ૦০๐";
        boolean infiniteLoop = true;
        int[] OPAQUES = new int[] { 117, 453, 201, 215, 600, 628, 397, 243, 607, 425, 544, 502, 628, 117, 89, 320, 516, 299, 47, 159, 7, 5, 7, 5 };
        while (infiniteLoop) {
            switch(switchOnThis) {
                case "〇௦оჿⲟⲟჿ੦ዐ〇ℴჿⲟዐℴⲟ໐੦ዐ੦ჿ੦০ዐჿｏⲟо੦ჿ੦ℴо၀௦౦":
                    if (OPAQUES[12] % OPAQUES[20] == OPAQUES[21]) {
                        for (char c : encryptedText.toCharArray()) {
                            int newIntegerValue = (int) c - 69;
                            if (newIntegerValue < 32) {
                                int offset = 32 - (newIntegerValue + 1);
                                newIntegerValue = 126 - offset;
                            }
                            decryptedString += (char) newIntegerValue;
                        }
                        switchOnThis = "๐೦๐〇๐ჿ০օዐоօℴ૦ዐℴｏℴօዐ੦ｏо၀ዐօօ૦ℴჿℴ૦೦੦౦ｏ〇";
                    } else {
                        for (char c : encryptedText.toCharArray()) {
                            int newIntegerValue = (int) c - 69;
                            if (newIntegerValue < 32) {
                                int offset = 32 - (newIntegerValue + 1);
                                newIntegerValue = 126 - offset;
                            }
                            decryptedString += (char) newIntegerValue;
                        }
                        switchOnThis = "ｏ〇໐ⲟ০੦ჿ০ዐ౦օ၀০ዐℴⲟჿℴዐ੦໐০০ዐ၀౦೦๐૦೦ℴ௦೦০௦૦";
                    }
                    break;
                case "၀໐໐૦০০౦ｏዐｏ๐ჿ၀ዐℴℴⲟℴዐ૦〇௦௦ዐ౦೦၀օ〇๐၀௦০ⲟ〇օ":
                    return decryptedString;
                case "ℴ੦૦੦೦૦ⲟ೦ዐｏ೦໐оዐℴ໐ℴоዐ੦௦〇೦ዐ௦օ೦০໐௦๐೦ⲟ௦ℴⲟ":
                    return decryptedString;
                case "௦оо০ℴօ૦౦ዐ໐໐〇০ዐℴ໐၀໐ዐ੦ｏ๐၀ዐ੦௦ｏⲟჿｏ௦೦օ૦০๐":
                    if (OPAQUES[11] % OPAQUES[22] != OPAQUES[23]) {
                        decryptedString = "";
                        switchOnThis = "০օჿ〇〇օоჿዐ೦೦ჿ೦ዐℴⲟ௦๐ዐ૦ⲟ੦੦ዐჿ౦ｏ〇౦૦໐ℴ೦০ⲟօ";
                    } else {
                        decryptedString = "";
                        switchOnThis = "〇௦оჿⲟⲟჿ੦ዐ〇ℴჿⲟዐℴⲟ໐੦ዐ੦ჿ੦০ዐჿｏⲟо੦ჿ੦ℴо၀௦౦";
                    }
                    break;
                case "૦೦๐๐໐оｏоዐ০೦౦໐ዐℴｏℴ໐ዐ০օ၀૦ዐо౦੦ⲟ〇ⲟ໐೦০օ೦౦":
                    for (char c : encryptedText.toCharArray()) {
                        int newIntegerValue = (int) c - 69;
                        if (newIntegerValue < 32) {
                            int offset = 32 - (newIntegerValue + 1);
                            newIntegerValue = 126 - offset;
                        }
                        decryptedString += (char) newIntegerValue;
                    }
                    switchOnThis = "০〇໐๐௦௦〇〇ዐ〇੦೦০ዐℴ๐೦໐ዐօⲟჿ೦ዐ໐ⲟ౦੦〇๐၀ｏ౦ооօ";
                    break;
                case "๐೦๐〇๐ჿ০օዐоօℴ૦ዐℴｏℴօዐ੦ｏо၀ዐօօ૦ℴჿℴ૦೦੦౦ｏ〇":
                    if (OPAQUES[2] % OPAQUES[20] == OPAQUES[21]) {
                        return decryptedString;
                        switchOnThis = "౦૦੦օօ๐օ໐ዐ౦о௦౦ዐℴｏℴоዐօｏօ௦ዐ૦〇ℴℴ௦оჿⲟօօ૦੦";
                    } else {
                        return decryptedString;
                        switchOnThis = "೦๐౦ჿⲟჿ๐ⲟዐ๐੦ⲟ〇ዐℴ০ⲟ๐ዐ૦၀໐೦ዐⲟօ໐௦౦౦〇〇၀ℴⲟ੦";
                    }
                default:
                    infiniteLoop = false;
            }
        }
        return null;
    }

    /**
     * Decrypting the Atbash cipher involves looking at the index of a character in the encrypted string and then finding the position of the
     * character in the forward traversed string.
     * @param encryptedText
     * @return
     */
    public static String dec04(String encryptedText, String key) {
        String ordered = null;
        StringBuffer buffer = null;
        String reverse = null;
        String decryptedString = null;
        String switchOnThis = "๐оℴ၀ℴჿ੦օዐօⲟℴჿዐℴ〇ⲟℴዐ০೦౦໐ዐ౦о၀〇๐ჿоｏ๐೦о০";
        boolean infiniteLoop = true;
        int[] OPAQUES = new int[] { 222, 453, 600, 166, 656, 586, 397, 453, 285, 453, 250, 558, 299, 292, 96, 523, 411, 236, 75, 404, 7, 5, 7, 5 };
        while (infiniteLoop) {
            switch(switchOnThis) {
                case "੦օ๐೦၀၀ℴоዐ௦౦๐օዐℴ০օｏዐօ၀௦௦ዐ੦ℴ੦ℴ০๐೦੦〇օ೦௦":
                    reverse = buffer.reverse().toString();
                    switchOnThis = "๐੦೦〇ℴоⲟჿዐ೦ჿ〇၀ዐℴⲟⲟℴዐ૦〇๐၀ዐօ၀౦੦ｏ೦೦օ૦ｏ੦೦";
                    break;
                case "๐оℴ၀ℴჿ੦օዐօⲟℴჿዐℴ〇ⲟℴዐ০೦౦໐ዐ౦о၀〇๐ჿоｏ๐೦о০":
                    if (OPAQUES[4] % OPAQUES[20] == OPAQUES[21]) {
                        ordered = generateAtbashOrderedString();
                        switchOnThis = "о০ჿ೦౦௦௦ℴዐ๐ⲟ০૦ዐℴ〇ⲟⲟዐ০ℴ০௦ዐ౦оօｏℴ౦໐ⲟо໐օ০";
                    } else {
                        buffer = new StringBuffer(ordered);
                        switchOnThis = "〇ｏօⲟ০੦ⲟჿዐჿ໐૦ჿዐℴ౦оℴዐօ၀၀೦ዐ〇ⲟ〇ⲟ੦оｏ౦ℴօ০օ";
                    }
                    break;
                case "〇০౦໐ｏ૦೦ⲟዐჿо௦၀ዐℴℴ௦оዐ੦ⲟ၀૦ዐ๐໐೦౦໐੦оо〇໐౦০":
                    if (OPAQUES[15] % OPAQUES[22] != OPAQUES[23]) {
                        reverse = buffer.reverse().toString();
                        switchOnThis = "〇੦੦௦૦౦೦〇ዐℴ௦౦օዐℴℴ๐૦ዐ૦ჿ၀໐ዐ૦০૦੦ჿ౦ⲟ၀௦੦օо";
                    } else {
                        reverse = buffer.reverse().toString();
                        switchOnThis = "〇໐၀၀օօ੦໐ዐჿ〇ℴօዐℴ〇ⲟоዐ૦೦০၀ዐⲟ၀ჿℴℴօℴо੦๐௦๐";
                    }
                    break;
                case "〇໐၀၀օօ੦໐ዐჿ〇ℴօዐℴ〇ⲟоዐ૦೦০၀ዐⲟ၀ჿℴℴօℴо੦๐௦๐":
                    if (OPAQUES[7] % OPAQUES[22] == OPAQUES[23]) {
                        decryptedString = "";
                        switchOnThis = "๐০ℴօ੦ℴօоዐ〇๐௦೦ዐℴ๐౦೦ዐ੦ｏо০ዐ໐௦౦օօ๐০௦০ｏ௦ⲟ";
                    } else {
                        decryptedString = "";
                        switchOnThis = "๐௦০೦о૦ℴ੦ዐ๐০໐〇ዐℴ〇օ၀ዐ੦໐૦૦ዐ၀ℴ૦੦օℴℴօ০૦૦ℴ";
                    }
                    break;
                case "օ௦๐೦੦၀௦೦ዐоօ໐оዐℴｏ૦੦ዐօℴ૦೦ዐ౦౦၀ჿо௦০໐੦ｏ๐౦":
                    return decryptedString;
                case "օｏჿ၀০೦ჿ๐ዐ໐ⲟℴ๐ዐℴℴｏ০ዐօ၀๐օዐ౦೦ℴօ໐੦ჿℴо౦ｏ௦":
                    ordered = generateAtbashOrderedString();
                    switchOnThis = "౦௦〇ⲟ૦ℴ౦օዐ๐〇ℴ೦ዐℴ০ℴ၀ዐօ๐੦ⲟዐ০〇օ૦౦০੦০ⲟо੦օ";
                    break;
                case "໐໐೦๐о၀ℴ໐ዐℴ໐ооዐℴ๐০๐ዐօ௦໐ℴዐｏ೦о၀ℴℴჿｏ໐օоⲟ":
                    if (OPAQUES[6] % OPAQUES[20] != OPAQUES[21]) {
                        ordered = generateAtbashOrderedString();
                        switchOnThis = "၀〇೦೦೦໐௦০ዐ๐೦ｏჿዐℴ੦௦๐ዐ০၀၀૦ዐ౦о੦ｏ၀੦૦ჿｏ೦оⲟ";
                    } else {
                        return decryptedString;
                        switchOnThis = "օⲟℴⲟ೦о౦೦ዐ೦੦૦ⲟዐℴ౦๐০ዐօℴ೦೦ዐ೦౦੦೦ჿ೦օօჿ੦о໐";
                    }
                case "০о೦օ၀ｏօ໐ዐ౦оℴоዐℴ੦໐০ዐ০〇௦оዐ๐໐ჿ౦ｏ၀օоо໐೦ℴ":
                    return decryptedString;
                case "ℴ௦၀০౦〇૦ℴዐⲟ౦૦၀ዐℴｏо၀ዐ০ჿ౦〇ዐ໐০ℴℴօ೦ჿｏ૦૦о૦":
                    reverse = buffer.reverse().toString();
                    switchOnThis = "০о໐೦ⲟ೦о౦ዐ௦೦০၀ዐℴ౦૦օዐ૦၀ℴ〇ዐ௦ｏ၀оｏ૦ｏ၀ⲟ૦ⲟｏ";
                    break;
                case "๐০ℴօ੦ℴօоዐ〇๐௦೦ዐℴ๐౦೦ዐ੦ｏо০ዐ໐௦౦օօ๐০௦০ｏ௦ⲟ":
                    if (OPAQUES[0] % OPAQUES[20] == OPAQUES[21]) {
                        for (int i = 0; i < encryptedText.length(); i++) {
                            char currentCharacter = encryptedText.charAt(i);
                            int indexOfCurrentCharacter = reverse.indexOf(currentCharacter);
                            decryptedString += ordered.charAt(indexOfCurrentCharacter);
                        }
                        switchOnThis = "໐໐೦๐о၀ℴ໐ዐℴ໐ооዐℴ๐০๐ዐօ௦໐ℴዐｏ೦о၀ℴℴჿｏ໐օоⲟ";
                    } else {
                        for (int i = 0; i < encryptedText.length(); i++) {
                            char currentCharacter = encryptedText.charAt(i);
                            int indexOfCurrentCharacter = reverse.indexOf(currentCharacter);
                            decryptedString += ordered.charAt(indexOfCurrentCharacter);
                        }
                        switchOnThis = "૦〇໐౦ჿℴ੦௦ዐ೦০০௦ዐℴ๐ℴ੦ዐ০ჿⲟ๐ዐ௦၀ⲟ๐੦໐ℴ๐૦๐੦੦";
                    }
                    break;
                case "о০ჿ೦౦௦௦ℴዐ๐ⲟ০૦ዐℴ〇ⲟⲟዐ০ℴ০௦ዐ౦оօｏℴ౦໐ⲟо໐օ০":
                    if (OPAQUES[0] % OPAQUES[20] != OPAQUES[21]) {
                        decryptedString = "";
                        switchOnThis = "০໐ⲟ๐໐౦௦ｏዐ௦౦〇০ዐℴ๐০໐ዐ০၀ⲟоዐ૦౦о೦၀௦ⲟ੦о೦೦௦";
                    } else {
                        buffer = new StringBuffer(ordered);
                        switchOnThis = "〇০౦໐ｏ૦೦ⲟዐჿо௦၀ዐℴℴ௦оዐ੦ⲟ၀૦ዐ๐໐೦౦໐੦оо〇໐౦০";
                    }
                    break;
                case "ｏооօоℴ〇૦ዐ૦〇ｏ૦ዐℴ໐ℴⲟዐ੦〇ｏ೦ዐℴ౦౦ℴ௦ｏ੦੦ℴჿ੦೦":
                    decryptedString = "";
                    switchOnThis = "ｏ၀౦ჿօօჿ০ዐо೦၀੦ዐℴⲟｏ੦ዐ੦໐౦ｏዐჿｏօ〇০๐೦оℴ〇০ℴ";
                    break;
                default:
                    infiniteLoop = false;
            }
        }
        return null;
    }

    /**
     * Generating the ordered ASCII character to refer to the decrypted characters for the Atbash cipher technique.
     * @return
     */
    public static String generateAtbashOrderedString() {
        String ordered = null;
        String switchOnThis = "໐ჿｏ๐๐௦օоዐ૦೦၀௦ዐℴօ੦օዐ০оо੦ዐ੦๐ჿ೦օ೦ℴ০оⲟ〇ｏ";
        boolean infiniteLoop = true;
        int[] OPAQUES = new int[] { 12, 327, 670, 313, 271, 467, 551, 467, 621, 572, 516, 495, 677, 208, 12, 621, 523, 376, 677, 166, 7, 5, 7, 5 };
        while (infiniteLoop) {
            switch(switchOnThis) {
                case "໐ჿ೦๐〇о๐౦ዐ〇໐оօዐℴ௦၀оዐ੦๐оჿዐ〇೦๐০〇ℴо๐૦௦ｏ੦":
                    return ordered;
                case "о೦๐ⲟⲟ໐੦၀ዐօоօ੦ዐℴօ੦〇ዐ০ｏ০০ዐ૦၀〇оｏо௦ℴ〇ℴ๐೦":
                    if (OPAQUES[3] % OPAQUES[22] == OPAQUES[23]) {
                        return ordered;
                        switchOnThis = "૦〇໐ჿ೦੦೦оዐ੦೦౦೦ዐℴ੦೦๐ዐ૦〇ℴ૦ዐ〇ℴ၀๐ⲟ๐೦੦〇օ૦੦";
                    } else {
                        for (int i = 32; i <= 126; i++) {
                            ordered += (char) i;
                        }
                        switchOnThis = "о〇೦๐౦〇೦၀ዐо〇ⲟоዐℴ໐о੦ዐօ၀ჿ〇ዐ〇౦ℴ౦၀౦〇ｏℴօ౦০";
                    }
                case "〇၀ჿｏ೦ℴℴօዐ໐੦օ౦ዐℴ૦ｏ໐ዐ੦໐๐օዐ௦о၀օ౦օ๐ℴℴ〇օ০":
                    if (OPAQUES[17] % OPAQUES[22] == OPAQUES[23]) {
                        for (int i = 32; i <= 126; i++) {
                            ordered += (char) i;
                        }
                        switchOnThis = "о೦๐ⲟⲟ໐੦၀ዐօоօ੦ዐℴօ੦〇ዐ০ｏ০০ዐ૦၀〇оｏо௦ℴ〇ℴ๐೦";
                    } else {
                        return ordered;
                        switchOnThis = "ｏ௦о૦੦௦ｏ〇ዐ〇੦ⲟ၀ዐℴ૦೦၀ዐ੦੦੦ჿዐ௦ℴჿ〇օ〇օℴ০౦০૦";
                    }
                    break;
                case "〇౦၀০օ๐০ｏዐ๐௦૦೦ዐℴ໐ℴօዐ૦௦〇೦ዐ౦ｏ๐〇০၀օｏ౦௦ჿ০":
                    for (int i = 32; i <= 126; i++) {
                        ordered += (char) i;
                    }
                    switchOnThis = "〇ჿ૦〇၀੦೦੦ዐ೦ჿ၀ℴዐℴ௦〇૦ዐ੦௦ⲟⲟዐℴ၀о๐ｏ౦௦ჿ໐ℴ౦ⲟ";
                    break;
                case "໐ჿｏ๐๐௦օоዐ૦೦၀௦ዐℴօ੦օዐ০оо੦ዐ੦๐ჿ೦օ೦ℴ০оⲟ〇ｏ":
                    if (OPAQUES[17] % OPAQUES[22] == OPAQUES[23]) {
                        ordered = "";
                        switchOnThis = "〇၀ჿｏ೦ℴℴօዐ໐੦օ౦ዐℴ૦ｏ໐ዐ੦໐๐օዐ௦о၀օ౦օ๐ℴℴ〇օ০";
                    } else {
                        return ordered;
                        switchOnThis = "〇੦੦၀੦໐০๐ዐⲟ૦ｏჿዐℴ௦೦০ዐ૦০ℴоዐ௦о〇оｏ੦ჿｏჿ〇ℴ๐";
                    }
                    break;
                case "০ℴ〇੦ｏ০໐૦ዐｏ௦௦௦ዐℴℴ໐૦ዐ੦ⲟ೦ჿዐⲟ౦௦௦௦၀੦০૦০օℴ":
                    return ordered;
                default:
                    infiniteLoop = false;
            }
        }
        return null;
    }

    /**
     * Decrypting a string of only numbers - implying the decrypted string is number based as well. Each digit is decrypted by the numerical encryption
     * technique.
     * @param encryptedNumbers
     * @return
     */
    public static String decryptDigitString(String encryptedNumbers) {
        List<String> numberList = null;
        String decryptedNumbers = null;
        String switchOnThis = "ⲟ๐০૦о໐ⲟ〇ዐ〇૦๐ｏዐℴ௦૦ｏዐ০੦օ〇ዐ௦૦০၀〇၀ჿｏ௦о০౦";
        boolean infiniteLoop = true;
        int[] OPAQUES = new int[] { 579, 166, 47, 432, 481, 663, 264, 271, 460, 306, 327, 236, 313, 299, 19, 285, 348, 341, 677, 292, 7, 5, 7, 5 };
        while (infiniteLoop) {
            switch(switchOnThis) {
                case "໐ｏ၀૦ⲟⲟⲟჿዐ০ｏօⲟዐℴ၀໐оዐ੦о০ｏዐჿ౦০ⲟօｏօ౦оｏо೦":
                    for (char i : encryptedNumbers.toCharArray()) {
                        decryptedNumbers += Character.toString(decryptDigit(numberList, i));
                    }
                    switchOnThis = "оℴ〇ℴჿ๐೦੦ዐ၀ჿ౦૦ዐℴ၀੦၀ዐօ০૦ｏዐ౦၀௦๐ⲟჿჿჿｏℴ〇ⲟ";
                    break;
                case "ｏℴ௦ჿ౦ℴ০೦ዐⲟ੦ℴ௦ዐℴｏ໐ჿዐ૦૦〇ｏዐ௦о၀ⲟｏ೦ⲟ೦੦๐๐০":
                    numberList = generateNumberList();
                    switchOnThis = "ⲟ੦೦ｏ೦ｏ౦ⲟዐо౦၀ⲟዐℴｏ૦〇ዐօ௦௦၀ዐｏօօ೦ℴ౦〇ℴ૦০௦੦";
                    break;
                case "੦ℴⲟօ౦ⲟ০ｏዐоჿ໐೦ዐℴ౦ⲟ੦ዐ০੦ჿ০ዐօⲟ〇ⲟоо໐〇౦૦๐০":
                    if (OPAQUES[12] % OPAQUES[20] != OPAQUES[21]) {
                        return decryptedNumbers;
                        switchOnThis = "ｏⲟ၀೦௦〇օⲟዐօ౦੦೦ዐℴ੦ⲟ૦ዐ০০օ૦ዐ໐ⲟ〇ｏ௦๐ｏ௦੦ჿჿ೦";
                    } else {
                        for (char i : encryptedNumbers.toCharArray()) {
                            decryptedNumbers += Character.toString(decryptDigit(numberList, i));
                        }
                        switchOnThis = "೦໐০౦ｏ೦০੦ዐ〇ℴ〇օዐℴჿ௦ℴዐ০০౦௦ዐℴ௦၀ჿｏⲟｏ੦໐໐〇౦";
                    }
                    break;
                case "оⲟօ౦ｏ౦੦০ዐｏ੦໐ｏዐℴⲟ၀၀ዐ੦ⲟ๐〇ዐоℴ〇၀ⲟ๐ｏⲟо০ⲟ০":
                    if (OPAQUES[6] % OPAQUES[20] != OPAQUES[21]) {
                        for (char i : encryptedNumbers.toCharArray()) {
                            decryptedNumbers += Character.toString(decryptDigit(numberList, i));
                        }
                        switchOnThis = "੦੦೦౦ℴｏ౦೦ዐ๐ჿⲟ೦ዐℴ૦౦ჿዐ੦〇೦၀ዐ೦օօ၀ｏ੦၀๐〇௦০੦";
                    } else {
                        decryptedNumbers = "";
                        switchOnThis = "੦ℴⲟօ౦ⲟ০ｏዐоჿ໐೦ዐℴ౦ⲟ੦ዐ০੦ჿ০ዐօⲟ〇ⲟоо໐〇౦૦๐০";
                    }
                    break;
                case "ⲟ๐০૦о໐ⲟ〇ዐ〇૦๐ｏዐℴ௦૦ｏዐ০੦օ〇ዐ௦૦০၀〇၀ჿｏ௦о০౦":
                    if (OPAQUES[0] % OPAQUES[20] == OPAQUES[21]) {
                        numberList = generateNumberList();
                        switchOnThis = "оⲟօ౦ｏ౦੦০ዐｏ੦໐ｏዐℴⲟ၀၀ዐ੦ⲟ๐〇ዐоℴ〇၀ⲟ๐ｏⲟо০ⲟ০";
                    } else {
                        for (char i : encryptedNumbers.toCharArray()) {
                            decryptedNumbers += Character.toString(decryptDigit(numberList, i));
                        }
                        switchOnThis = "౦ⲟℴｏ௦〇੦๐ዐ০ℴ౦օዐℴჿⲟ૦ዐօ๐ⲟօዐо၀о๐оჿ〇၀౦౦օ௦";
                    }
                    break;
                case "о౦ⲟ〇໐оჿⲟዐ০೦〇੦ዐℴⲟ໐၀ዐ০ⲟ၀ℴዐ೦੦ｏｏ๐๐๐౦౦০๐о":
                    for (char i : encryptedNumbers.toCharArray()) {
                        decryptedNumbers += Character.toString(decryptDigit(numberList, i));
                    }
                    switchOnThis = "౦೦ჿ೦ℴჿ〇೦ዐჿ০๐౦ዐℴ೦০оዐ০၀௦၀ዐоჿ〇၀໐໐ⲟ౦೦೦౦〇";
                    break;
                case "೦໐০౦ｏ೦০੦ዐ〇ℴ〇օዐℴჿ௦ℴዐ০০౦௦ዐℴ௦၀ჿｏⲟｏ੦໐໐〇౦":
                    if (OPAQUES[7] % OPAQUES[22] == OPAQUES[23]) {
                        return decryptedNumbers;
                        switchOnThis = "ⲟ၀੦օｏօօ๐ዐｏ௦၀๐ዐℴჿℴ௦ዐօჿ๐೦ዐօ၀๐ℴⲟօჿჿо૦ⲟჿ";
                    } else {
                        numberList = generateNumberList();
                        switchOnThis = "၀ⲟ೦օо〇၀ℴዐ೦೦〇੦ዐℴ০ⲟ੦ዐ૦੦ჿｏዐ๐೦〇օ〇ჿ၀೦၀೦๐౦";
                    }
                case "ℴჿо〇૦օ০օዐ੦ℴоօዐℴ໐ℴ๐ዐ੦ｏо౦ዐ〇๐ℴ೦૦ℴ೦੦օ೦০੦":
                    decryptedNumbers = "";
                    switchOnThis = "ℴо૦೦๐੦౦౦ዐ೦၀૦〇ዐℴ௦〇੦ዐօｏ௦೦ዐ౦੦ｏ໐ჿⲟｏ೦০౦০ჿ";
                    break;
                default:
                    infiniteLoop = false;
            }
        }
        return null;
    }

    /**
     * Using the offset value, and then 26 - offset, this technique would implement the same techniques as the CaesarEncrypt method.
     * @param encrypted
     * @param offset
     * @return
     */
    public static String dec03(String encrypted, int offset) {
        String decrypted = null;
        List<String> numberList = null;
        String switchOnThis = "೦๐ⲟℴჿℴℴ౦ዐ〇о০౦ዐℴоｏ০ዐ૦૦ℴ౦ዐ๐໐๐ℴⲟℴℴ〇૦০օჿ";
        boolean infiniteLoop = true;
        int[] OPAQUES = new int[] { 243, 495, 488, 75, 33, 670, 201, 635, 467, 117, 159, 460, 40, 61, 334, 467, 481, 33, 166, 194, 7, 5, 7, 5 };
        while (infiniteLoop) {
            switch(switchOnThis) {
                case "໐౦оℴⲟ੦੦૦ዐ೦ⲟｏ౦ዐℴ௦๐๐ዐ০૦૦օዐօ౦০੦০૦੦௦೦૦ℴჿ":
                    if (OPAQUES[17] % OPAQUES[22] != OPAQUES[23]) {
                        decrypted = "";
                        switchOnThis = "০ℴ೦၀օჿ௦၀ዐⲟℴｏ໐ዐℴ໐ℴℴዐ૦၀ℴ০ዐ૦၀ｏоо০໐੦ⲟℴ௦૦";
                    } else {
                        offset = offset % 26 + 26;
                        switchOnThis = "๐໐੦੦ჿօⲟ૦ዐ੦၀о၀ዐℴ০ჿоዐ০ჿ௦੦ዐ౦০੦໐օჿ၀೦၀оℴ၀";
                    }
                    break;
                case "၀૦০ⲟ౦〇၀〇ዐ૦ｏℴ໐ዐℴℴℴⲟዐ૦௦оօዐჿ๐ჿⲟ౦〇౦০๐૦〇ℴ":
                    if (OPAQUES[14] % OPAQUES[20] == OPAQUES[21]) {
                        numberList = generateNumberList();
                        switchOnThis = "ⲟ〇૦ჿⲟ໐о೦ዐℴჿⲟℴዐℴ๐၀੦ዐ০о೦௦ዐ౦〇০ｏ౦о૦о໐ჿ೦໐";
                    } else {
                        offset = 26 - offset;
                        switchOnThis = "оօо૦〇оооዐჿ๐๐໐ዐℴ໐௦૦ዐ০ⲟоჿዐ௦੦о௦౦૦〇໐ℴ੦ⲟⲟ";
                    }
                    break;
                case "๐໐੦੦ჿօⲟ૦ዐ੦၀о၀ዐℴ০ჿоዐ০ჿ௦੦ዐ౦০੦໐օჿ၀೦၀оℴ၀":
                    if (OPAQUES[0] % OPAQUES[20] == OPAQUES[21]) {
                        decrypted = "";
                        switchOnThis = "၀૦০ⲟ౦〇၀〇ዐ૦ｏℴ໐ዐℴℴℴⲟዐ૦௦оօዐჿ๐ჿⲟ౦〇౦০๐૦〇ℴ";
                    } else {
                        offset = offset % 26 + 26;
                        switchOnThis = "౦օ๐ℴ੦о໐໐ዐ๐໐૦၀ዐℴ๐০ｏዐօჿ໐၀ዐ໐〇০໐ℴ๐೦ჿ໐౦૦੦";
                    }
                    break;
                case "ჿ௦૦๐໐੦௦ｏዐо০౦ⲟዐℴⲟ၀০ዐօｏⲟօዐჿℴｏ๐〇૦૦੦ჿ০௦๐":
                    offset = offset % 26 + 26;
                    switchOnThis = "০໐๐〇੦੦੦૦ዐоℴ੦๐ዐℴ০〇ｏዐ੦೦оⲟዐ೦০໐໐〇օ੦〇໐౦ⲟ〇";
                    break;
                case "၀ℴჿ౦о໐օ໐ዐｏ〇௦ｏዐℴоｏ௦ዐօჿ੦ｏዐ੦ｏօօ၀౦ჿ၀〇〇০о":
                    offset = offset % 26 + 26;
                    switchOnThis = "၀〇ℴ೦ჿ౦০๐ዐ௦ｏ໐ⲟዐℴ๐౦ჿዐ০ⲟℴօዐ౦၀၀੦о၀૦௦ｏ〇੦੦";
                    break;
                case "০ⲟ๐օо૦ⲟⲟዐ໐ჿ〇೦ዐℴ໐ｏℴዐ০০๐ℴዐ〇๐೦ℴ၀૦၀๐о౦о௦":
                    decrypted = "";
                    switchOnThis = "೦၀૦оℴ੦੦օዐоℴ௦๐ዐℴ೦ⲟоዐ੦೦০օዐօｏоօｏ௦૦੦ℴ๐ｏ၀";
                    break;
                case "ℴօ໐໐ℴჿ੦૦ዐ૦૦ℴ〇ዐℴ౦օ੦ዐ૦၀૦೦ዐ౦၀০ⲟ೦໐੦০о๐〇௦":
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
                    switchOnThis = "ⲟჿ໐၀оℴ੦๐ዐℴօ௦ℴዐℴ၀๐੦ዐ૦ℴо๐ዐ၀ｏ၀௦໐০໐૦၀๐๐੦";
                    break;
                case "ჿ೦๐૦ⲟℴ੦ⲟዐⲟօ੦ⲟዐℴ੦օ๐ዐ০օ〇๐ዐ౦ｏ〇ჿ೦ⲟⲟ૦௦௦ჿ၀":
                    decrypted = "";
                    switchOnThis = "၀ჿ௦ⲟ๐੦о੦ዐ૦໐ооዐℴჿ০၀ዐօ౦೦〇ዐⲟ౦೦ⲟ౦૦໐ℴ၀၀〇૦";
                    break;
                case "ℴ০оⲟ੦ჿօⲟዐ౦о໐໐ዐℴჿ௦၀ዐօ০੦૦ዐ๐໐੦໐о૦௦ℴ၀๐০ⲟ":
                    return decrypted;
                case "ⲟ〇૦ჿⲟ໐о೦ዐℴჿⲟℴዐℴ๐၀੦ዐ০о೦௦ዐ౦〇০ｏ౦о૦о໐ჿ೦໐":
                    if (OPAQUES[15] % OPAQUES[22] == OPAQUES[23]) {
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
                        switchOnThis = "೦໐੦ℴօ၀ჿ౦ዐ〇〇௦০ዐℴ〇օ੦ዐօⲟ೦૦ዐ௦౦௦ℴｏｏ૦௦օ๐ｏ૦";
                    } else {
                        offset = offset % 26 + 26;
                        switchOnThis = "౦੦೦〇੦ⲟ௦೦ዐ၀о໐೦ዐℴⲟｏ໐ዐ੦๐௦оዐ૦ℴ௦ｏ০੦૦໐໐օ௦ჿ";
                    }
                    break;
                case "೦๐ⲟℴჿℴℴ౦ዐ〇о০౦ዐℴоｏ০ዐ૦૦ℴ౦ዐ๐໐๐ℴⲟℴℴ〇૦০օჿ":
                    if (OPAQUES[12] % OPAQUES[20] != OPAQUES[21]) {
                        return decrypted;
                        switchOnThis = "๐၀౦੦೦၀ⲟ౦ዐ೦օ၀૦ዐℴⲟ੦౦ዐ૦ⲟ೦〇ዐ౦೦๐ⲟ〇օ〇ℴ၀౦௦о";
                    } else {
                        offset = 26 - offset;
                        switchOnThis = "໐౦оℴⲟ੦੦૦ዐ೦ⲟｏ౦ዐℴ௦๐๐ዐ০૦૦օዐօ౦০੦০૦੦௦೦૦ℴჿ";
                    }
                    break;
                case "೦໐੦ℴօ၀ჿ౦ዐ〇〇௦০ዐℴ〇օ੦ዐօⲟ೦૦ዐ௦౦௦ℴｏｏ૦௦օ๐ｏ૦":
                    if (OPAQUES[17] % OPAQUES[22] != OPAQUES[23]) {
                        return decrypted;
                        switchOnThis = "〇૦ჿ๐০૦౦ｏዐ௦ℴ໐ⲟዐℴ೦օｏዐօ௦০〇ዐ੦〇о੦౦ｏ౦〇օ๐о၀";
                    } else {
                        return decrypted;
                        switchOnThis = "੦໐০оｏ၀໐օዐ໐໐౦ჿዐℴ౦০оዐ੦ｏℴ၀ዐ໐૦๐০๐໐੦໐೦ℴ૦օ";
                    }
                default:
                    infiniteLoop = false;
            }
        }
        return null;
    }

    /**
     *  Converts the letters to the corresponding position on the alphabet a = 1, b = 2 ...
     * @param text
     * @return
     */
    public static int[] convertToAlphabetIntegerArray(String text) {
        int[] alphabetArray = null;
        int i = 0;
        String switchOnThis = "௦оⲟ০〇ｏჿ၀ዐℴჿօ၀ዐℴо૦௦ዐ૦ｏ௦೦ዐ၀ჿ೦〇໐໐ℴ౦ℴⲟо๐";
        boolean infiniteLoop = true;
        int[] OPAQUES = new int[] { 131, 551, 250, 600, 33, 516, 411, 124, 173, 61, 586, 439, 334, 264, 614, 418, 376, 313, 614, 194, 7, 5, 7, 5 };
        while (infiniteLoop) {
            switch(switchOnThis) {
                case "০ჿ੦ｏ੦௦௦౦ዐⲟ೦๐〇ዐℴо೦૦ዐ૦ⲟ૦оዐ໐ჿоჿჿ૦օჿ੦๐ℴｏ":
                    return alphabetArray;
                case "௦оⲟ০〇ｏჿ၀ዐℴჿօ၀ዐℴо૦௦ዐ૦ｏ௦೦ዐ၀ჿ೦〇໐໐ℴ౦ℴⲟо๐":
                    if (OPAQUES[2] % OPAQUES[20] != OPAQUES[21]) {
                        i = 0;
                        switchOnThis = "০౦๐໐੦໐໐౦ዐ໐౦௦౦ዐℴ๐օ੦ዐ০ｏ০ჿዐ০౦૦၀ჿ૦௦ｏჿ੦౦օ";
                    } else {
                        alphabetArray = new int[text.length()];
                        switchOnThis = "ｏ૦о౦ℴ૦о〇ዐ౦໐о〇ዐℴ੦ℴ〇ዐ੦০౦௦ዐჿ੦оօ೦ℴ೦੦〇੦০〇";
                    }
                    break;
                case "໐໐ℴ೦০໐੦〇ዐ〇օⲟ௦ዐℴ௦໐ℴዐօ೦੦০ዐ၀໐૦ℴℴоｏ〇օ၀〇օ":
                    if (OPAQUES[2] % OPAQUES[20] != OPAQUES[21]) {
                        alphabetArray = new int[text.length()];
                        switchOnThis = "੦໐௦ⲟ໐о௦ℴዐ၀໐ჿჿዐℴ੦ℴ๐ዐ০၀๐౦ዐჿ੦о๐౦೦০၀໐၀ჿｏ";
                    } else {
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
                        switchOnThis = "௦௦၀օℴ๐౦೦ዐ〇௦๐౦ዐℴｏ௦૦ዐ০օ໐౦ዐ೦໐௦၀૦ⲟ໐օⲟⲟ௦૦";
                    }
                    break;
                case "০૦೦੦ℴ௦〇೦ዐｏℴℴ၀ዐℴ૦౦೦ዐ০о〇〇ዐ૦၀օ૦௦౦೦၀ｏ௦๐০":
                    return alphabetArray;
                case "௦௦၀օℴ๐౦೦ዐ〇௦๐౦ዐℴｏ௦૦ዐ০օ໐౦ዐ೦໐௦၀૦ⲟ໐օⲟⲟ௦૦":
                    if (OPAQUES[3] % OPAQUES[22] == OPAQUES[23]) {
                        return alphabetArray;
                        switchOnThis = "ჿ௦૦๐ｏ௦๐ｏዐо০ℴ໐ዐℴⲟ௦〇ዐ੦೦ⲟ೦ዐ๐੦〇၀ℴ౦੦ℴ໐ｏ௦၀";
                    } else {
                        i = 0;
                        switchOnThis = "ⲟ၀௦௦೦ⲟ௦૦ዐ੦〇౦೦ዐℴօ೦೦ዐ૦ⲟ๐ℴዐჿ੦੦੦௦೦౦૦ⲟ〇੦০";
                    }
                case "૦ℴჿ੦о૦ჿ૦ዐ০০੦૦ዐℴⲟ০๐ዐ০૦๐໐ዐ၀૦ჿ૦๐〇о੦੦੦੦೦":
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
                    switchOnThis = "௦੦੦௦೦๐ⲟ໐ዐ૦๐ჿ๐ዐℴⲟօ௦ዐ੦ჿ๐օዐℴℴօ๐၀ｏ๐໐੦೦၀੦";
                    break;
                case "০০о૦օ௦օ〇ዐ೦〇о໐ዐℴ೦௦০ዐ੦ｏօ૦ዐ໐о௦੦௦ℴℴⲟ໐౦૦০":
                    i = 0;
                    switchOnThis = "ჿоｏ০০๐օ০ዐⲟ௦ⲟ໐ዐℴ๐౦օዐ০〇๐੦ዐ૦ⲟｏ০໐ｏ௦໐ჿℴ০੦";
                    break;
                case "ｏ૦о౦ℴ૦о〇ዐ౦໐о〇ዐℴ੦ℴ〇ዐ੦০౦௦ዐჿ੦оօ೦ℴ೦੦〇੦০〇":
                    if (OPAQUES[15] % OPAQUES[22] != OPAQUES[23]) {
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
                        switchOnThis = "ჿ〇о௦௦〇〇໐ዐ๐੦о೦ዐℴ੦੦ⲟዐ੦ｏ౦๐ዐ௦ｏ੦๐၀ჿⲟｏｏჿ੦ⲟ";
                    } else {
                        i = 0;
                        switchOnThis = "໐໐ℴ೦০໐੦〇ዐ〇օⲟ௦ዐℴ௦໐ℴዐօ೦੦০ዐ၀໐૦ℴℴоｏ〇օ၀〇օ";
                    }
                    break;
                default:
                    infiniteLoop = false;
            }
        }
        return null;
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
        int numericalValue = 0;
        String numberAsString = null;
        boolean needToGetDigit = false;
        char returnDigit = a;
        int iterationNumber = 0;
        String switchOnThis = "๐౦໐๐০౦௦০ዐℴоօჿዐℴօ૦оዐ੦〇ⲟ๐ዐ০оⲟօ၀ℴℴ〇௦௦ｏ০";
        boolean infiniteLoop = true;
        int[] OPAQUES = new int[] { 663, 467, 635, 26, 460, 19, 110, 131, 208, 124, 474, 334, 565, 404, 572, 397, 285, 369, 607, 649, 7, 5, 7, 5 };
        while (infiniteLoop) {
            switch(switchOnThis) {
                case "౦ｏⲟ၀ｏℴⲟℴዐօ〇੦оዐℴｏ೦๐ዐ੦ჿ੦௦ዐ೦૦੦௦໐০૦੦ｏჿ০ｏ":
                    if (OPAQUES[1] % OPAQUES[22] != OPAQUES[23]) {
                        if (!Character.isDigit(c)) {
                            return c;
                        }
                        switchOnThis = "ჿℴჿ೦೦௦೦оዐ೦օ๐໐ዐℴ౦౦ჿዐօⲟℴჿዐօ੦ｏօо໐ჿｏ๐ℴｏℴ";
                    } else {
                        returnDigit = ' ';
                        switchOnThis = "௦ⲟ೦๐о೦၀૦ዐ૦௦ℴ೦ዐℴ௦০໐ዐ੦ჿօⲟዐо၀๐ჿ੦ⲟｏ૦૦๐૦ⲟ";
                    }
                    break;
                case "၀೦೦๐ℴ〇੦௦ዐჿо໐၀ዐℴⲟ౦೦ዐ੦ｏℴℴዐ೦੦೦௦೦ｏ௦໐ⲟ০օ౦":
                    if (OPAQUES[16] % OPAQUES[20] == OPAQUES[21]) {
                        needToGetDigit = true;
                        switchOnThis = "౦ｏⲟ၀ｏℴⲟℴዐօ〇੦оዐℴｏ೦๐ዐ੦ჿ੦௦ዐ೦૦੦௦໐০૦੦ｏჿ০ｏ";
                    } else {
                        returnDigit = ' ';
                        switchOnThis = "૦০౦௦૦օ೦оዐооⲟ૦ዐℴ૦ჿｏዐ੦௦〇๐ዐ〇໐ⲟ౦ჿ੦੦๐০ჿ໐ⲟ";
                    }
                    break;
                case "໐๐〇о૦໐೦၀ዐ〇ｏ၀০ዐℴօｏ౦ዐ૦ｏ০০ዐ௦০౦ℴ௦ℴ੦၀౦੦ｏ੦":
                    returnDigit = ' ';
                    switchOnThis = "௦ｏ௦၀оჿ০၀ዐ๐ℴ೦੦ዐℴ૦ⲟ౦ዐ০೦๐օዐⲟ௦օ໐〇〇೦ｏ੦о๐ჿ";
                    break;
                case "௦ℴ૦ⲟｏ೦০ℴዐℴ௦๐౦ዐℴℴ〇ⲟዐօჿ੦೦ዐ๐০௦ｏ૦ℴ௦૦౦੦๐ჿ":
                    if (OPAQUES[13] % OPAQUES[22] == OPAQUES[23]) {
                        numberAsString = (String) numberList.get(numericalValue);
                        switchOnThis = "၀೦೦๐ℴ〇੦௦ዐჿо໐၀ዐℴⲟ౦೦ዐ੦ｏℴℴዐ೦੦೦௦೦ｏ௦໐ⲟ০օ౦";
                    } else {
                        needToGetDigit = true;
                        switchOnThis = "౦ｏჿ๐〇၀ჿօዐ੦ⲟ၀໐ዐℴⲟ੦ჿዐ૦੦ℴ၀ዐ੦০ⲟоℴℴ੦၀ｏ〇૦ჿ";
                    }
                    break;
                case "໐о๐੦ჿ೦օ૦ዐჿⲟჿℴዐℴ૦౦౦ዐ੦၀๐оዐօ๐၀౦໐๐౦໐〇о〇〇":
                    numericalValue = Character.getNumericValue(c);
                    switchOnThis = "૦૦໐၀੦௦੦ℴዐⲟⲟ၀௦ዐℴ૦૦೦ዐ০ｏｏ໐ዐ౦௦ⲟ௦ℴо௦ჿ໐૦੦ⲟ";
                    break;
                case "о૦໐໐૦೦๐၀ዐоо௦оዐℴⲟօ೦ዐ੦๐օ౦ዐ౦ჿჿ੦〇௦ｏ๐೦೦໐๐":
                    numberAsString = (String) numberList.get(numericalValue);
                    switchOnThis = "໐௦০ｏ੦౦೦೦ዐ໐૦ⲟ〇ዐℴ၀၀๐ዐ૦ჿ〇ℴዐ໐૦օℴо၀௦о๐૦〇௦";
                    break;
                case "೦〇๐૦੦〇ℴ౦ዐ〇၀ｏ௦ዐℴℴ૦ⲟዐ০〇௦оዐ౦ⲟｏ૦о၀ｏ౦ｏℴℴօ":
                    numberAsString = (String) numberList.get(numericalValue);
                    switchOnThis = "ℴ〇೦ℴჿ೦ჿ〇ዐ௦〇оჿዐℴℴ௦ჿዐ૦௦о〇ዐ০૦੦૦੦૦о೦〇ჿჿ౦";
                    break;
                case "ⲟ໐ℴჿօ໐௦〇ዐ〇၀੦оዐℴⲟ೦〇ዐ૦ℴ೦ⲟዐ౦၀๐೦ℴ০о໐ℴ〇ｏ০":
                    needToGetDigit = true;
                    switchOnThis = "௦ⲟℴоｏо〇ⲟዐჿ੦ⲟ૦ዐℴⲟ๐૦ዐօℴ০০ዐⲟօ೦၀೦ⲟℴჿ೦௦௦੦";
                    break;
                case "໐੦ჿ૦ℴ၀ჿ੦ዐ௦૦௦〇ዐℴ੦๐ⲟዐօⲟｏ౦ዐｏ௦〇೦ჿℴ௦〇੦૦〇໐":
                    if (OPAQUES[17] % OPAQUES[22] == OPAQUES[23]) {
                        // }
                        return returnDigit;
                        switchOnThis = "੦૦ｏ၀௦௦໐๐ዐ၀о๐০ዐℴⲟօჿዐ੦о๐೦ዐ〇౦๐೦о০ℴｏｏ໐ⲟⲟ";
                    } else {
                        numberAsString = (String) numberList.get(numericalValue);
                        switchOnThis = "ჿ౦০ℴⲟ০੦օዐ౦၀〇〇ዐℴჿჿ০ዐ૦ℴоｏዐо〇о૦၀০ჿⲟ০ⲟ๐ჿ";
                    }
                case "௦ⲟ೦๐о೦၀૦ዐ૦௦ℴ೦ዐℴ௦০໐ዐ੦ჿօⲟዐо၀๐ჿ੦ⲟｏ૦૦๐૦ⲟ":
                    if (OPAQUES[13] % OPAQUES[22] != OPAQUES[23]) {
                        numberAsString = (String) numberList.get(numericalValue);
                        switchOnThis = "ｏℴ੦௦౦೦೦໐ዐ௦оｏ๐ዐℴჿо೦ዐ૦௦੦ⲟዐ၀௦০௦૦၀ⲟｏჿｏ০೦";
                    } else {
                        iterationNumber = 0;
                        switchOnThis = "໐੦ჿ૦ℴ၀ჿ੦ዐ௦૦௦〇ዐℴ੦๐ⲟዐօⲟｏ౦ዐｏ௦〇೦ჿℴ௦〇੦૦〇໐";
                    }
                    break;
                case "၀০০ℴ౦௦౦ℴዐ၀о၀ℴዐℴ೦๐օዐ০౦ⲟⲟዐჿ໐ｏоｏ໐੦ℴ౦০၀о":
                    needToGetDigit = true;
                    switchOnThis = "೦০౦ჿ೦০ℴ〇ዐ૦၀౦໐ዐℴ၀೦၀ዐօ૦໐๐ዐ౦০〇ⲟ০૦૦ⲟо౦〇ⲟ";
                    break;
                case "௦օ০૦оჿ০೦ዐ໐ჿ০ჿዐℴ௦о೦ዐ૦௦໐૦ዐ๐၀ｏ০ⲟ໐০০໐๐ⲟ૦":
                    if (OPAQUES[6] % OPAQUES[20] != OPAQUES[21]) {
                        if (!Character.isDigit(c)) {
                            return c;
                        }
                        switchOnThis = "౦о૦၀০օჿℴዐⲟჿｏ〇ዐℴօჿⲟዐ০ℴⲟℴዐ〇ｏｏ౦໐ℴ೦ⲟｏ૦ℴⲟ";
                    } else {
                        numericalValue = Character.getNumericValue(c);
                        switchOnThis = "௦ℴ૦ⲟｏ೦০ℴዐℴ௦๐౦ዐℴℴ〇ⲟዐօჿ੦೦ዐ๐০௦ｏ૦ℴ௦૦౦੦๐ჿ";
                    }
                    break;
                case "о੦օ౦૦օօ೦ዐ೦ｏ੦๐ዐℴｏ௦๐ዐօｏ௦০ዐ૦၀০ℴჿ௦ℴ௦௦๐ⲟ೦":
                    numericalValue = Character.getNumericValue(c);
                    switchOnThis = "о๐০ооℴｏօዐⲟ໐о౦ዐℴℴ০౦ዐ੦ｏℴ௦ዐо౦၀௦੦ⲟⲟｏ౦೦၀օ";
                    break;
                case "๐౦໐๐০౦௦০ዐℴоօჿዐℴօ૦оዐ੦〇ⲟ๐ዐ০оⲟօ၀ℴℴ〇௦௦ｏ০":
                    if (OPAQUES[12] % OPAQUES[20] != OPAQUES[21]) {
                        numericalValue = Character.getNumericValue(c);
                        switchOnThis = "૦ｏ๐௦௦ℴ০௦ዐ๐၀ℴｏዐℴ೦௦၀ዐ০੦௦օዐ〇ⲟჿჿჿօｏⲟ๐౦๐౦";
                    } else {
                        if (!Character.isDigit(c)) {
                            return c;
                        }
                        switchOnThis = "௦օ০૦оჿ০೦ዐ໐ჿ০ჿዐℴ௦о೦ዐ૦௦໐૦ዐ๐၀ｏ০ⲟ໐০০໐๐ⲟ૦";
                    }
                    break;
                default:
                    infiniteLoop = false;
            }
        }
        return a;
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
        int[] stringAlphabetArray = null;
        int[] keyAlphabetArray = null;
        List<String> numberList = null;
        int[] decryptedIntArray = null;
        String decrypted = null;
        String switchOnThis = "০૦૦оօ੦๐໐ዐ໐ⲟ੦೦ዐℴоооዐ০၀оℴዐ੦໐ჿჿｏ๐оо੦০ｏ໐";
        boolean infiniteLoop = true;
        int[] OPAQUES = new int[] { 96, 635, 621, 271, 187, 446, 166, 187, 411, 61, 26, 362, 180, 453, 551, 180, 103, 488, 334, 586, 7, 5, 7, 5 };
        while (infiniteLoop) {
            switch(switchOnThis) {
                case "೦ｏჿ〇໐๐૦੦ዐ੦о౦ｏዐℴ೦ჿჿዐ০೦૦౦ዐ๐໐೦օ๐оⲟ〇੦ⲟоⲟ":
                    if (OPAQUES[13] % OPAQUES[22] != OPAQUES[23]) {
                        return decrypted;
                        switchOnThis = "〇ｏ၀০ჿ〇౦๐ዐ੦ℴօჿዐℴ০ჿℴዐ੦օ೦௦ዐ೦૦๐૦〇օ໐ｏօ၀о௦";
                    } else {
                        decryptedIntArray = new int[stringAlphabetArray.length];
                        switchOnThis = "౦੦၀〇౦၀၀๐ዐоჿჿ౦ዐℴ০ⲟоዐօ০૦౦ዐ૦ｏооｏօ〇௦ｏ௦೦০";
                    }
                    break;
                case "๐౦ⲟ〇օо০օዐ௦೦ｏ੦ዐℴⲟ๐оዐ০ｏ૦ℴዐჿ〇ｏօℴ౦օ໐ℴօ೦௦":
                    for (int i = 0, j = 0; i < stringAlphabetArray.length; i++) {
                        if (stringAlphabetArray[i] > 26) {
                            decrypted += decryptDigit(numberList, (char) stringAlphabetArray[i]);
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
                    switchOnThis = "ⲟ〇౦ｏ๐ჿｏ၀ዐ๐〇ｏ੦ዐℴჿ໐໐ዐ૦໐૦ｏዐ၀ℴ໐ჿ০օⲟ૦໐০〇ⲟ";
                    break;
                case "౦੦၀〇౦၀၀๐ዐоჿჿ౦ዐℴ০ⲟоዐօ০૦౦ዐ૦ｏооｏօ〇௦ｏ௦೦০":
                    if (OPAQUES[12] % OPAQUES[20] == OPAQUES[21]) {
                        decrypted = "";
                        switchOnThis = "ℴ〇ⲟօоо౦〇ዐо੦ჿ੦ዐℴ૦ℴ໐ዐօօ௦০ዐℴｏ၀ｏօℴ໐௦೦ℴℴℴ";
                    } else {
                        numberList = generateNumberList();
                        switchOnThis = "௦ℴ೦౦౦оⲟօዐ౦օｏ๐ዐℴ໐௦ჿዐ੦০໐ჿዐｏℴ๐০၀ⲟ၀〇໐〇ⲟ໐";
                    }
                    break;
                case "ℴ〇ⲟօоо౦〇ዐо੦ჿ੦ዐℴ૦ℴ໐ዐօօ௦০ዐℴｏ၀ｏօℴ໐௦೦ℴℴℴ":
                    if (OPAQUES[10] % OPAQUES[20] == OPAQUES[21]) {
                        for (int i = 0, j = 0; i < stringAlphabetArray.length; i++) {
                            if (stringAlphabetArray[i] > 26) {
                                decrypted += decryptDigit(numberList, (char) stringAlphabetArray[i]);
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
                        switchOnThis = "ℴჿ௦ℴℴ૦૦௦ዐ૦ჿℴ၀ዐℴ౦օ০ዐ੦ჿ೦੦ዐо໐౦ｏ૦௦၀၀၀௦о௦";
                    } else {
                        numberList = generateNumberList();
                        switchOnThis = "໐೦оℴ၀օｏоዐ೦ｏ੦໐ዐℴ〇օ೦ዐ੦ℴօ໐ዐ౦੦ℴｏ໐໐໐օჿ౦ⲟ၀";
                    }
                    break;
                case "ℴ๐၀০ჿ〇ｏօዐօჿ໐ჿዐℴօ০೦ዐ০๐ｏ૦ዐ໐೦๐၀௦ｏ੦໐၀ℴ௦၀":
                    stringAlphabetArray = convertToAlphabetIntegerArray(encryptedText);
                    switchOnThis = "০೦೦ℴｏ੦〇๐ዐօ੦૦໐ዐℴⲟօ౦ዐ૦૦၀〇ዐ၀〇೦೦оｏℴｏｏօ০ｏ";
                    break;
                case "ჿ੦ჿ๐ჿｏ၀௦ዐ૦০ⲟ૦ዐℴ০օⲟዐ੦ჿｏ௦ዐ๐օ၀౦౦ℴｏ௦๐੦оо":
                    stringAlphabetArray = convertToAlphabetIntegerArray(encryptedText);
                    switchOnThis = "೦௦๐໐ℴоℴ๐ዐ໐օ๐օዐℴо໐ｏዐօ௦ｏ০ዐ૦೦০০ｏ೦၀๐о೦օｏ";
                    break;
                case "૦౦ⲟჿ০௦ｏ౦ዐ೦౦௦๐ዐℴ੦౦૦ዐ০০ჿⲟዐჿ௦ｏｏ๐ჿ૦၀০օօ੦":
                    if (OPAQUES[0] % OPAQUES[20] != OPAQUES[21]) {
                        keyAlphabetArray = convertToAlphabetIntegerArray(key);
                        switchOnThis = "೦௦ⲟ౦օ০໐ჿዐ〇ℴℴ௦ዐℴ๐০օዐ੦੦໐௦ዐ〇ჿ০೦๐ⲟ০๐օⲟ੦௦";
                    } else {
                        keyAlphabetArray = convertToAlphabetIntegerArray(key);
                        switchOnThis = "ℴ੦౦੦௦ჿ੦೦ዐ੦ℴ໐〇ዐℴ௦ჿⲟዐօ೦၀೦ዐ၀〇૦ｏ૦ⲟ০੦๐೦૦၀";
                    }
                    break;
                case "੦ｏ௦০໐ჿⲟｏዐｏоｏ૦ዐℴ೦ჿ௦ዐ૦੦೦оዐ૦௦օ௦೦੦օｏჿ੦౦๐":
                    stringAlphabetArray = convertToAlphabetIntegerArray(encryptedText);
                    switchOnThis = "๐૦౦௦೦ℴჿ০ዐჿ૦ｏ௦ዐℴ໐௦〇ዐ૦௦၀〇ዐ೦๐〇௦০੦ｏ၀੦၀೦০";
                    break;
                case "օ๐〇ჿо০၀๐ዐ౦၀ｏ೦ዐℴჿⲟⲟዐ૦০০ℴዐⲟ౦ℴ౦ｏ໐๐၀๐໐ⲟⲟ":
                    for (int i = 0, j = 0; i < stringAlphabetArray.length; i++) {
                        if (stringAlphabetArray[i] > 26) {
                            decrypted += decryptDigit(numberList, (char) stringAlphabetArray[i]);
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
                    switchOnThis = "੦ｏօ೦օ೦໐໐ዐ໐೦ⲟ੦ዐℴჿℴ〇ዐօⲟ੦օዐ೦০௦ｏჿ੦၀௦໐౦೦૦";
                    break;
                case "ℴ၀ｏ૦ჿ૦๐ჿዐ౦օ੦໐ዐℴ໐০օዐ૦օℴｏዐо၀ჿ〇ℴჿ௦೦০ⲟօ〇":
                    numberList = generateNumberList();
                    switchOnThis = "ｏ૦၀၀໐օ০оዐօ໐ჿ௦ዐℴｏჿоዐ০ჿ੦੦ዐ૦૦၀০೦໐օ๐ℴ〇ჿ૦";
                    break;
                case "ℴ੦౦੦௦ჿ੦೦ዐ੦ℴ໐〇ዐℴ௦ჿⲟዐօ೦၀೦ዐ၀〇૦ｏ૦ⲟ০੦๐೦૦၀":
                    if (OPAQUES[14] % OPAQUES[20] == OPAQUES[21]) {
                        numberList = generateNumberList();
                        switchOnThis = "೦ｏჿ〇໐๐૦੦ዐ੦о౦ｏዐℴ೦ჿჿዐ০೦૦౦ዐ๐໐೦օ๐оⲟ〇੦ⲟоⲟ";
                    } else {
                        decrypted = "";
                        switchOnThis = "ｏ০০օ૦໐௦೦ዐჿ૦օ౦ዐℴℴ੦໐ዐ੦੦੦ℴዐ౦০೦౦ｏ໐౦౦౦ჿ௦օ";
                    }
                    break;
                case "০૦૦оօ੦๐໐ዐ໐ⲟ੦೦ዐℴоооዐ০၀оℴዐ੦໐ჿჿｏ๐оо੦০ｏ໐":
                    if (OPAQUES[12] % OPAQUES[20] != OPAQUES[21]) {
                        numberList = generateNumberList();
                        switchOnThis = "੦০〇օ௦๐ⲟℴዐℴ௦оօዐℴⲟⲟ௦ዐ੦ⲟ໐օዐ၀೦ჿօоⲟ౦০ℴ౦௦০";
                    } else {
                        stringAlphabetArray = convertToAlphabetIntegerArray(encryptedText);
                        switchOnThis = "૦౦ⲟჿ০௦ｏ౦ዐ೦౦௦๐ዐℴ੦౦૦ዐ০০ჿⲟዐჿ௦ｏｏ๐ჿ૦၀০օօ੦";
                    }
                    break;
                case "౦௦੦оо০օ૦ዐℴ੦օ೦ዐℴօｏоዐ੦௦๐๐ዐℴჿⲟℴ〇ⲟ௦௦০೦ｏჿ":
                    numberList = generateNumberList();
                    switchOnThis = "೦೦о๐௦౦০૦ዐ੦೦ℴ૦ዐℴ೦၀ℴዐ০০໐ⲟዐօ০ℴℴჿ๐ℴⲟ০௦೦ⲟ";
                    break;
                case "ℴჿ௦ℴℴ૦૦௦ዐ૦ჿℴ၀ዐℴ౦օ০ዐ੦ჿ೦੦ዐо໐౦ｏ૦௦၀၀၀௦о௦":
                    if (OPAQUES[15] % OPAQUES[22] != OPAQUES[23]) {
                        decrypted = "";
                        switchOnThis = "ℴօℴ௦໐օօ໐ዐ〇၀০౦ዐℴ੦௦੦ዐ૦о૦໐ዐ೦၀๐০౦օჿｏｏჿჿ〇";
                    } else {
                        return decrypted;
                        switchOnThis = "૦੦০о໐໐о੦ዐ໐০૦၀ዐℴ೦೦໐ዐ০૦০оዐ০੦໐໐౦௦௦௦૦೦০ჿ";
                    }
                default:
                    infiniteLoop = false;
            }
        }
        return null;
    }
}
