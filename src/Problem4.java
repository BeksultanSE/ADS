/*
* This is the class for solving Problem4
* */
public class Problem4 {
    /*
     * This method calculates the factorial of a given number.
     * It uses recursive approach
     * Time complexity: O(n), where n is the input number.
     * The recursive algorithm iterates through all numbers from n to 1,
     * resulting in linear time complexity.
     *
     * @param n The number for which the factorial is to be calculated.
     * @return The factorial of the given number.
     * */
    public static long findFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * findFactorial(n - 1);
    }

}
