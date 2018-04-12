package rotacsufbo;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.expr.Expression;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class OpaquePredator {

    private ArrayList<Integer> opaques;
    //element 0, 1 form a pair, 2, 3 form a pair IE = [0] mod [1], [2] mod [3]

    public OpaquePredator() {
        opaques = makeOpaques(20); // max length is 24 (0-23);
    }

    public Expression makeTrueExpression(String name) {
        boolean b = ThreadLocalRandom.current().nextBoolean();
        int rand;
        String s;
        if (b) {
            // EVEN
            rand = ThreadLocalRandom.current().nextInt(0, 10) * 2; //pair with 0/1
            // name.get(rand) % name.get(0) =? name.get(1);
            // can expand to more statement types
            System.out.println(opaques.get(rand) + " " + opaques.get(20) + " " + opaques.get(21));
             s = name + ".get(" + rand + ") % " + name + ".get(20) == " + name + ".get(21)";
        } else {
            rand = ThreadLocalRandom.current().nextInt(0, 10) * 2 + 1; // pair with 2/3
            // name.get(rand) % name.get(2) =? name.get(3);
            s = name + ".get(" + rand + ") % " + name + ".get(22) == " + name + ".get(23)";
        }

        return JavaParser.parseExpression(s);

    }

    private ArrayList<Integer> makeOpaques(int total) {
        //generate pairs
        // so we can check if VALUE % [ELEM0] = [ELEM1]
        ArrayList<Integer> opaque = new ArrayList<>();

        int modBy1 = 7; // mod by
        int remainder1 = 5; // remainder
        int modBy2 = 11;
        int remainder2 = 13;




        boolean flag = true;
        for (int i = 0; i < total; i++) {
            int validNumber = ThreadLocalRandom.current().nextInt(1, 97);
            if (flag) {
                int value = (validNumber * modBy1) + remainder1;
                opaque.add(value);
            } else {
                int value = (validNumber * modBy2) + remainder2;
                opaque.add(value);
            }
            flag = !flag;
        }

        opaque.add(modBy1); //20
        opaque.add(remainder1); //21
        opaque.add(modBy2); //22
        opaque.add(remainder2); //23
        return opaque;
    }



}
