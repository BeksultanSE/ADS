/*
 * This is the class for solving Problem2
 */
public class Problem2 {

    /*
     * This method calculates the average of elements in an array of integers.
     *
     * Time complexity: O(n), where n is the number of elements in the input array.
     * The method iterates through each element of the array once to calculate the sum,
     * and then divides the sum by the number of elements to find the average.
     *
     * @param arr The input array of integers.
     * @return The average of the elements in the input array.
     */
    public static double calculateAverage(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return (double) sum / arr.length;
    }
}
