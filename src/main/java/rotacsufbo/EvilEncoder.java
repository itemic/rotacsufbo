package rotacsufbo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;

public class EvilEncoder {

    /**
     * Encodes a string into base64 but then replaces with other random characters to make it harder to decode.
     * @param original A string to be encoded
     * @return Encoded string with arbitrary characters
     */
    public static String encode(String original) {
        String encoded = Base64.getEncoder().encodeToString(original.getBytes());
        String words = "abcdef1234567890-";
        String encryptedOddy = "੦૦௦౦೦๐໐၀ｏℴⲟоჿօ০〇ዐⵔ";
        String[] array = words.split("");
        String[] otherArray = encoded.split("");

        String[] from = words.split("");
        String[] to = encryptedOddy.split("");


        ArrayList<String> newStringAsArray = new ArrayList<>();
        for (int i = 0; i < encoded.length(); i++) {
            int ascii = (int)otherArray[i].charAt(0);
            newStringAsArray.add(array[ascii]);
        }
        String finalString = String.join("", newStringAsArray);
        return finalString;
//        return original;

    }

    public static String uuidEncode(String original) {
        String words = "abcdef1234567890-";
        String encryptedOddy = "੦૦௦౦೦๐໐၀ｏℴⲟоჿօ০〇ዐⵔ";

        ArrayList<String> from = new ArrayList<>(Arrays.asList(words.split("")));
        ArrayList<String> to = new ArrayList<>(Arrays.asList(encryptedOddy.split("")));
        ArrayList<String> orig = new ArrayList<>(Arrays.asList(original.split("")));

//        String[] to = encryptedOddy.split("");

        String[] originalArray = original.split("");

        ArrayList<String> newStringAsArray = new ArrayList<>();
        for (String s: orig) {
            newStringAsArray.add(to.get(from.indexOf(s)));
        }
        String finalString = String.join("", newStringAsArray);
        return finalString;
    }
}
