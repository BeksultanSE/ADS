import TestingClasses.*;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        testHashMap();
        testBST();
    }
    public static void testBST(){
        BST<Integer, String> tree = new BST<>();
        tree.put(1, "Iliyas");
        tree.put(3, "Adlet");
        tree.put(4, "Dimash");
        tree.put(2, "Bekzat");
        for (BST.Node elem : tree) {

            System.out.println("key is " + elem.getKey() + " and value is " + elem.getValue());

        }
    }
    public static void testHashMap(){
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<MyTestingClass, Student>();
        Random random = new Random();

        for (int i = 1; i <= 10000; i++) {
            MyTestingClass key = new MyTestingClass(random.nextInt());
            int v = random.nextInt();
            Student value = new Student(i, "Iam" + v);
            table.put(key, value);
        }
        table.print();
    }
}