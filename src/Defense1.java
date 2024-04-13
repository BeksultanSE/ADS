import static java.lang.Character.toLowerCase;

public class Defense1 {
    public static int countOccurrences(String s, char letter){
        if (s.isEmpty())return 0;
        int check = 0;
        if (toLowerCase(s.charAt(0)) == toLowerCase(letter))check = 1;
        return check + countOccurrences(s.substring(1), letter);
    }
}
