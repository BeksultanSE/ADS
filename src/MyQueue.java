public class MyQueue<T extends Comparable<T>> {

    private MyLinkedList<T> queue;

    MyQueue(){
        queue = new MyLinkedList<>();
    }

    boolean empty(){
        return size() == 0;
    }
    int size(){
        return queue.size();
    }

    T peek(){
        return queue.getFirst();
    }

    T enqueue(T item){
        queue.addLast(item);
        return item;
    }

    T dequeue(){
        T removed = queue.getFirst();
        queue.removeFirst();
        return removed;
    }
}
