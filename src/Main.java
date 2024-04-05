import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the task number (1-10) or 0 to exit");
        int task = sc.nextInt();
        switch (task) {
            case 1:
                task1();
                break;
            case 2:
                task2();
                break;
            case 3:
                task3();
                break;
            case 4:
                task4();
                break;
            case 5:
                task5();
                break;
            case 6:
                task6();
                break;
            case 7:
                task7();
                break;
            case 8:
                task8();
                break;
            case 9:
                task9();
                break;
            case 10:
                task10();
                break;
        }
        System.out.println("Program is finished!");
        sc.close();
    }
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
    public static void task3(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number:");
        int n = scanner.nextInt();
        if (Problem3.isPrime(n)) {
            System.out.println("Prime");
        } else {
            System.out.println("Composite");
        }
    }
    public static void task4(){

    }
    public static void task5(){

    }
    public static void task6(){

    }
    public static void task7(){

    }
    public static void task8(){

    }
    public static void task9(){

    }
    public static void task10(){

    }
}