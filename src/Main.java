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
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
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

}