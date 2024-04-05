/*
 * This is the class for solving Problem10
 */
public class Problem10 {

    /*
     * This method calculates the greatest common divisor (GCD) of two numbers using recursion.
     *
     * Time complexity: O(log(min(a, b))), where a and b are the input integers.
     * The method uses the Euclidean algorithm, which has a logarithmic time complexity
     * relative to the minimum of the two input integers.
     *
     * @param a The first integer.
     * @param b The second integer.
     * @return The greatest common divisor (GCD) of 'a' and 'b'.
     */
    public static int findGCD(int a, int b){
        if(b == 0){
            return a;
        }
        return findGCD(b, a % b);
    }
}
