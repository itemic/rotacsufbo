package rotacsufbo;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.expr.Expression;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Opaque predicates are essentially more complicated ways of representing a boolean
 */
public class OpaquePredicates {

//    private ArrayList<Integer> opaques;
    private int[] opaques;
    //element 0, 1 form a pair, 2, 3 form a pair IE = [0] mod [1], [2] mod [3]

    public OpaquePredicates() {
        makeOpaques(); // max length is 24 (0-23);
    }

    /**
     * Create an expression that is essentially true
     * @param name
     * @return
     */
    public Expression makeTrueExpression(String name) {
        boolean b = ThreadLocalRandom.current().nextBoolean();
        int rand;
        String s;
        if (b) {
            // EVEN
            rand = ThreadLocalRandom.current().nextInt(0, 10) * 2; //pair with 0/1
            // name.get(rand) % name.get(0) =? name.get(1);
            // can expand to more statement types
             s = name + "[" + rand + "] % " + name + "[20] == " + name + "[21]";
        } else {
            rand = ThreadLocalRandom.current().nextInt(0, 10) * 2 + 1; // pair with 2/3
            // name.get(rand) % name.get(2) =? name.get(3);
            s = name + "[" + rand + "] % " + name + "[22] == " + name + "[23]";
        }

        return JavaParser.parseExpression(s);

    }

    /**
     * Create an expression that is essentially false
     * @param name
     * @return
     */
    public Expression makeFalseExpression(String name) {
        boolean b = ThreadLocalRandom.current().nextBoolean();
        int rand;
        String s;
        if (b) {
            // EVEN
            rand = ThreadLocalRandom.current().nextInt(0, 10) * 2; //pair with 0/1
            // name.get(rand) % name.get(0) =? name.get(1);
            // can expand to more statement types
            s = name + "[" + rand + "] % " + name + "[20] != " + name + "[21]";
        } else {
            rand = ThreadLocalRandom.current().nextInt(0, 10) * 2 + 1; // pair with 2/3
            // name.get(rand) % name.get(2) =? name.get(3);
            s = name + "[" + rand + "] % " + name + "[22] != " + name + "[23]";
        }

        return JavaParser.parseExpression(s);

    }

    /**
     * Create the array to hold "random" numbers
     */
    private void makeOpaques() {
        //generate pairs
        // so we can check if VALUE % [ELEM0] = [ELEM1]
        ArrayList<Integer> opaque = new ArrayList<>();
        opaques = new int[24];


        int modBy1 = 7; // mod by
        int remainder1 = 5; // remainder
        int modBy2 = 7;
        int remainder2 = 5;


        boolean flag = true;
        for (int i = 0; i < 20; i++) {
            int validNumber = ThreadLocalRandom.current().nextInt(1, 97);
            if (flag) {
                int value = (validNumber * modBy1) + remainder1;
                opaques[i] = value;
            } else {
                int value = (validNumber * modBy2) + remainder2;
                opaques[i] = value;
            }
            flag = !flag;
        }

        opaques[20]=modBy1; //20
        opaques[21] = remainder1; //21
        opaques[22] =modBy2; //22
        opaques[23] =remainder2; //23

    }

    public int[] getOpaques() {
        return opaques;
    }



}
