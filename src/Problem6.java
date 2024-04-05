/*
 * This is the class for solving Problem6
 */
public class Problem6 {

    /*
     * This method calculates the power of a number recursively.
     *
     * Time complexity: O(n), where n is the exponent.
     * The method makes 'n' recursive calls to compute the power,
     * resulting in a linear increase in the number of function calls.
     *
     * @param a The base number.
     * @param n The exponent.
     * @return The result of raising 'a' to the power of 'n'.
     */
    public static long power(int a, int n){
        if (n == 0) return 1;
        return a * power(a, n - 1);
    }
}
