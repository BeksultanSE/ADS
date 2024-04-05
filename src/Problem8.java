import static java.lang.Character.isDigit;

public class Problem8 {
    public static boolean allDigits(String s){
        if(s.length() == 1){
            return (isDigit(s.charAt(0)));
        }
        return (isDigit(s.charAt(0)) & allDigits(s.substring(1)));
    }
}
