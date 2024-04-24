public class Main {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(12);
        queue.enqueue(3);
        queue.enqueue(14);

        System.out.println(queue.size());
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue.peek());

    }

}