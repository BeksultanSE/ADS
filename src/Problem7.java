import java.util.Scanner;

/*
 * This is the class for solving Problem7
 */
public class Problem7 {

    /*
     * This method reads 'n' integers from the scanner 'sc' and prints them in reverse order.
     *
     * Time complexity: O(n), where n is the number of integers to be read and printed.
     * The method recursively reads and prints each integer, resulting in a linear increase
     * in the number of function calls proportional to 'n'.
     *
     * @param sc The scanner object from which integers are read.
     * @param n The number of integers to be read and printed.
     */
    public static void inReverse(Scanner sc, int n){
        if (n == 0){
            System.out.println();
            return;
        }
        int element = sc.nextInt();
        inReverse(sc, n - 1);
        System.out.print(element + " ");

    }

}
