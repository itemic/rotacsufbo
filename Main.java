import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int a = 0;
        int name = 0;
        String switchOnThis = "০ℴ௦ℴⲟｏ০౦ዐо๐ⲟ೦ዐℴჿⲟоዐ০ⲟ੦๐ዐо၀௦೦ｏ০೦೦০০૦ｏ";
        boolean infiniteLoop = true;
        int[] OPAQUES = new int[] { 47, 327, 173, 124, 257, 376, 607, 33, 341, 425, 110, 229, 516, 656, 271, 607, 628, 271, 145, 663, 7, 5, 7, 5 };
        while (infiniteLoop) {
            switch(switchOnThis) {
                case "օ૦๐๐๐ℴօჿዐ૦০๐૦ዐℴ໐૦оዐօ೦ჿ๐ዐჿ೦௦૦౦౦௦໐օ০၀౦":
                    a = 3;
                    switchOnThis = "ℴ೦૦ｏо〇օ೦ዐ၀౦೦૦ዐℴⲟ໐੦ዐ০০ℴ〇ዐоо૦〇〇౦о၀ℴｏ੦ჿ";
                    break;
                case "ℴｏჿℴ೦〇ⲟ੦ዐℴｏо೦ዐℴ໐૦౦ዐ੦օ๐๐ዐჿ๐੦๐๐ооо໐ⲟ〇๐":
                    if (OPAQUES[13] % OPAQUES[22] == OPAQUES[23]) {
                        name = 4;
                        switchOnThis = "೦౦੦ℴ๐օｏ૦ዐ௦๐ჿ౦ዐℴ੦оჿዐ੦௦ℴ໐ዐⲟｏ௦ℴ೦о੦ℴ০၀၀〇";
                    } else {
                        name = 4;
                        switchOnThis = "໐ⲟ૦о੦೦ℴｏዐоօ০೦ዐℴоⲟჿዐ੦૦ｏｏዐ〇໐ｏ໐ｏ၀௦೦೦ℴ၀၀";
                    }
                    break;
                case "০૦௦ｏჿօ૦੦ዐ০๐૦ｏዐℴჿჿօዐ੦੦૦օዐօℴ০ჿօ೦๐օօ၀ℴօ":
                    a = 3;
                    switchOnThis = "օ໐๐੦๐૦໐〇ዐ໐౦੦໐ዐℴ໐๐ჿዐ੦ⲟⲟ೦ዐ၀ℴℴ௦ⲟⲟｏо〇౦௦໐";
                    break;
                case "໐໐૦օօо০օዐჿ௦ⲟ೦ዐℴⲟｏ၀ዐօℴօ໐ዐ௦ℴⲟ೦௦௦౦ｏ੦〇ⲟ〇":
                    if (OPAQUES[0] % OPAQUES[20] != OPAQUES[21]) {
                        a = 3;
                        switchOnThis = "໐੦օ੦೦ｏჿ௦ዐ〇о૦૦ዐℴ๐ℴℴዐ੦໐о౦ዐо౦๐၀০〇౦૦௦ⲟ০ჿ";
                    } else {
                        a = 3;
                        switchOnThis = "ℴｏჿℴ೦〇ⲟ੦ዐℴｏо೦ዐℴ໐૦౦ዐ੦օ๐๐ዐჿ๐੦๐๐ооо໐ⲟ〇๐";
                    }
                    break;
                case "০ℴ௦ℴⲟｏ০౦ዐо๐ⲟ೦ዐℴჿⲟоዐ০ⲟ੦๐ዐо၀௦೦ｏ০೦೦০০૦ｏ":
                    if (OPAQUES[12] % OPAQUES[20] == OPAQUES[21]) {
                        System.out.println("mohan");
                        switchOnThis = "໐໐૦օօо০օዐჿ௦ⲟ೦ዐℴⲟｏ၀ዐօℴօ໐ዐ௦ℴⲟ೦௦௦౦ｏ੦〇ⲟ〇";
                    } else {
                        name = 4;
                        switchOnThis = "೦о০၀૦〇ℴ၀ዐօ๐೦౦ዐℴо〇๐ዐ૦౦૦౦ዐ௦օ੦౦௦௦ⲟｏｏ໐օо";
                    }
                    break;
                case "೦〇໐〇໐૦ჿ೦ዐ০০о೦ዐℴ໐໐ⲟዐօ๐о໐ዐⲟ೦၀〇০ⲟ௦ℴ௦๐ℴ໐":
                    name = 4;
                    switchOnThis = "ⲟ੦оⲟჿօо໐ዐ౦ℴ๐๐ዐℴｏ〇૦ዐօօჿ〇ዐ೦ⲟ၀੦၀օо໐๐௦ℴ๐";
                    break;
                default:
                    infiniteLoop = false;
            }
        }
    }
}
