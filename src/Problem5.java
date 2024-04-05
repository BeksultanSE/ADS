/*
 * This is the class for solving Problem5
 */
public class Problem5 {

    /*
     * This method finds the nth Fibonacci number recursively.
     *
     * Time complexity: O(2^n), where n is the input number.
     * This is because each call to the function branches into two recursive calls,
     * resulting in an exponential growth in the number of function calls.
     * This makes the time complexity exponential.
     *
     * @param n The index of the Fibonacci number to find.
     * @return The nth Fibonacci number.
     */
    public static int findFibonacci(int n){
        if (n == 0) return 0;
        if (n == 1) return 1;
        return findFibonacci(n - 1) + findFibonacci(n - 2);
    }
}
