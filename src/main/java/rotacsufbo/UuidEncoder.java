package rotacsufbo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;

public class UuidEncoder {


    /**
     * Encodes a UUID (base16) into a list of similar-looking O characters
     * @param original
     * @return
     */
    public static String uuidEncode(String original) {
        String words = "abcdef1234567890-";
        String encryptedOddy = "੦૦௦౦೦๐໐၀ｏℴⲟоჿօ০〇ዐⵔ";

        ArrayList<String> from = new ArrayList<>(Arrays.asList(words.split("")));
        ArrayList<String> to = new ArrayList<>(Arrays.asList(encryptedOddy.split("")));
        ArrayList<String> orig = new ArrayList<>(Arrays.asList(original.split("")));


        ArrayList<String> newStringAsArray = new ArrayList<>();
        for (String s: orig) {
            newStringAsArray.add(to.get(from.indexOf(s)));
        }
        String finalString = String.join("", newStringAsArray);
        return finalString;
    }
}
