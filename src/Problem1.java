/*
 * This is the class for solving Problem1
 */
public class Problem1 {

    /*
     * This method finds the minimum value in an array of integers.
     *
     * Time complexity: O(n), where n is the number of elements in the input array.
     * The method iterates through each element of the array once to find the minimum value.
     *
     * @param arr The input array of integers.
     * @return The minimum value found in the input array.
     */
    public static int Min(int[] arr){
        int min = Integer.MAX_VALUE;
        for (int j : arr) {
            min = Integer.min(min, j);
        }
        return min;
    }
}
