import TestingClasses.*;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        testHashMap();

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