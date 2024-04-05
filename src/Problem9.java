/*
 * This is the class for solving Problem9
 */
public class Problem9 {

    /*
     * This method calculates the binomial coefficient "n choose k" recursively.
     *
     * Time complexity: O(2^n), where n is the value of 'n' and k is the value of 'k'.
     * The method makes two recursive calls for each call, resulting in an exponential
     * increase in the number of function calls and thus exponential time complexity.
     *
     * @param n The total number of items.
     * @param k The number of items to choose.
     * @return The binomial coefficient "n choose k".
     */
    public static long findCnk(int n, int k){
        if(k == 0 || n == k){
            return 1;
        }
        return findCnk(n - 1, k - 1) + findCnk(n - 1, k);
    }
}
