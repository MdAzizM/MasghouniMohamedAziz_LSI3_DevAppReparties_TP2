package ACT1;
import java.util.Set;
import java.util.regex.Pattern;


public class Validator {
    public static char searchOP(String req) {
        Set<Character> validOps = Set.of('+', '-', '*', '/');
        char op=' ';
        for (char c : req.toCharArray()) {
            if (validOps.contains(c)) {
                op = c;
                return op;
            }
        }
        return op;
    }
    public static boolean opValid(String req){
        Set<Character> validOps = Set.of('+', '-', '*', '/');
        int opNB = 0;
        for (char c : req.toCharArray()) {
            if (validOps.contains(c)) {
                opNB++;
            }else {
                if (!(Character.isDigit(c) || Character.isWhitespace(c))) {
                    System.out.println("Error: ["+c+"] is not a valid operator!");
                    return false;
                }
            }
        }
        if (opNB != 1) {
            System.out.println("Error: ["+opNB+" ops] Must contain exactly one operator");
            return false;
        }
        return true;
    }

    public static boolean number(String req){
        for (int i=0;i<req.length();i++){
            char c =req.charAt(i);
            if (Character.isLetter(c)){
                System.out.println("Error: must contains only numbers");
                return false;
            }
        }
        return true;
    }
    public static boolean syntaxe(String req){
        return number(req) && opValid(req);
    }
    public static boolean form(String req) {
        String word = req.replaceAll("\\s", "");
        char op = searchOP(word);
        String[] Numbers = word.split(Pattern.quote(String.valueOf(op)));


        if (Numbers.length != 2) {
            System.out.println("Error: Expression format invalid");
            return false;
        } else {
            String left = Numbers[0];
            String right = Numbers[1];
            System.out.println("Expression format Correct: "+left+op+right);
            return true;
        }
    }
    public static boolean valide(String req){
        if (syntaxe(req)){
            System.out.println("****Syntaxe is correct****\n|||checking form|||");
            if (form(req)){
                System.out.println("****Form is correct****\n====> Request is VALIDE!");
                return true;
            }else {
                System.out.println("!!!!Form is NOT correct!!!!");
                return false;
            }
        }else {
            System.out.println("!!!!Syntaxe is NOT correct!!!!");
            return false;
        }
    }
}
