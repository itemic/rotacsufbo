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
        String words = "坝壩板备備贝貝笔筆毕畢边邊宾賓才纔蚕蠶灿燦层層搀攙谗讒馋饞缠厂廠彻徹尘塵衬襯称稱惩懲迟遲冲衝丑醜出聪聰丛叢参參仓倉产產长長尝嘗车車齿齒虫蟲刍芻从從窜竄担擔胆膽导導灯燈邓鄧敌敵籴糴递遞点點淀澱电電冬鼕斗鬥独獨吨噸夺奪堕墮达達带帶单單当當当噹党黨东東动動断斷对對队隊儿兒尔爾矾礬范範飞飛坟墳奋奮粪糞凤鳳肤膚妇婦复復复複发發发髮丰豐风風";
        String[] array = words.split("");
        String[] otherArray = encoded.split("");
        ArrayList<String> newStringAsArray = new ArrayList<>();

        for (int i = 0; i < encoded.length(); i++) {
            int ascii = (int)otherArray[i].charAt(0);
            newStringAsArray.add(array[ascii]);
        }
        String finalString = String.join("", newStringAsArray);
        return finalString;
//        return original;

    }
}
