package rotacsufbo;

/*
Helper class to get the default value of a type.
 */
public class DefaultsHelper {

    public static Object getDefault(String s) {

        switch(s) {
            case "boolean":
                return false;
            case "int":
                return 0;
            case "byte":
                return 0;
            case "short":
                return 0;
            case "long":
                return 0L;
            case "float":
                return 0.0F;
            case "double":
                return 0.0d;
            case "char":
                return 'a';
            default:
                return null;

        }

    }

}
