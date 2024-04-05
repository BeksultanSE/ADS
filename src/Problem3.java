/*
 * This is the class for solving Problem3
 */
public class Problem3 {

    /*
     * This method checks if a given number is a prime number.
     *
     * Time complexity: O(sqrt(n)), where n is the input number.
     * The method iterates from 2 to the square root of n to check for divisibility.
     * Checking divisibility up to the square root reduces the number of iterations,
     * making it more efficient than checking up to n.
     *
     * @param n The number to be checked for primality.
     * @return True if the given number is prime, false otherwise.
     */
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
