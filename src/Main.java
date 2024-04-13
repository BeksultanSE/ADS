import java.util.Scanner;

public class Main {
    /*
    * Main executing code block that takes the problem number as an input
    * and finishes after the problem solution is executed
    * */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the task number (1-10) or 0 to exit (11 is defence task)");
        int task = sc.nextInt();
        switch (task) {
            case 1:
                timeTaken(Main::task1);
                break;
            case 2:
                timeTaken(Main::task2);
                break;
            case 3:
                timeTaken(Main::task3);
                break;
            case 4:
                timeTaken(Main::task4);
                break;
            case 5:
                timeTaken(Main::task5);
                break;
            case 6:
                timeTaken(Main::task6);
                break;
            case 7:
                timeTaken(Main::task7);
                break;
            case 8:
                timeTaken(Main::task8);
                break;
            case 9:
                timeTaken(Main::task9);
                break;
            case 10:
                timeTaken(Main::task10);
                break;
            case 11:
                timeTaken(Main::task11);
                break;
        }
        System.out.println("Program is finished!");
        sc.close();
    }
    /*
    * This method calculates the time taken for compilation of the task.
    *
    * @param task The method of the task to be calculated
    * */
    public static void timeTaken(Runnable task){
        double startTime = System.nanoTime();
        task.run();
        double endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1000000; //Convert nanoseconds to milliseconds
        System.out.println("Time taken: " + duration + " milliseconds");
    }
    /*
     * Task 1: Read array size and elements, then find minimum value
     */
    public static void task1(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the size of an array:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int min = Problem1.Min(arr);
        System.out.println(min);
    }

    /*
     * Task 2: Read array size and elements, then calculate average
     */
    public static void task2(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements (n > 0):");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        double avg = Problem2.calculateAverage(arr);
        System.out.println("The average of the elements is: " + avg);
    }

    /*
     * Task 3: Check if a given number is prime or composite
     */
    public static void task3(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:");
        int n = sc.nextInt();
        if (Problem3.isPrime(n)) {
            System.out.println("Prime");
        } else {
            System.out.println("Composite");
        }
    }

    /*
     * Task 4: Read a number and calculate its factorial
     */
    public static void task4(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:");
        int n = sc.nextInt();
        long ans = Problem4.findFactorial(n);
        System.out.println(ans);
    }

    /*
     * Task 5: Read a number and find its Fibonacci number
     */
    public static void task5(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:");
        int n = sc.nextInt();
        int ans = Problem5.findFibonacci(n);
        System.out.println(ans);
    }

    /*
     * Task 6: Read two numbers and calculate the power of one raised to the other
     */
    public static void task6(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 2 numbers:");
        int a = sc.nextInt(), n = sc.nextInt();

        long ans = Problem6.power(a, n);
        System.out.println(ans);
    }

    /*
     * Task 7: Read the number of elements and print them in reverse order
     */
    public static void task7(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements");
        int n = sc.nextInt();
        Problem7.inReverse(sc, n);
    }

    /*
     * Task 8: Read a string and check if it contains all digits
     */
    public static void task8(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String s = sc.next();
        System.out.println((Problem8.allDigits(s) ? "Yes" : "No"));
    }

    /*
     * Task 9: Read two numbers and find the binomial coefficient
     */
    public static void task9(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 2 numbers(n and k) for finding binomial coefficient:");
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(Problem9.findCnk(n, k));
    }

    /*
     * Task 10: Read two numbers and find their greatest common divisor
     */
    public static void task10(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 2 numbers(a and b) for finding GCD");
        int a = sc.nextInt(), b = sc.nextInt();
        System.out.println(Problem10.findGCD(a, b));
    }



    public static void task11(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String s = sc.next();
        System.out.println("Enter the char: ");
        char letter = sc.next().charAt(0);
        int result = Defense1.countOccurrences(s, letter);
        System.out.println(result);
    }
}