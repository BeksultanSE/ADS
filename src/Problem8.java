import static java.lang.Character.isDigit;

/*
 * This is the class for solving Problem8
 */
public class Problem8 {

    /*
     * This method checks if all characters in the given string are digits.
     *
     * Time complexity: O(n), where n is the length of the input string 's'.
     * The method iterates through each character of the string once to check if it's a digit.
     *
     * @param s The input string to be checked.
     * @return True if all characters in the string are digits, false otherwise.
     */
    public static boolean allDigits(String s){
        if(s.length() == 1){
            return (isDigit(s.charAt(0)));
        }
        return (isDigit(s.charAt(0)) & allDigits(s.substring(1)));
    }
}
