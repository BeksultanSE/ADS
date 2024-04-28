public class MyQueue<T extends Comparable<T>> {
    // The underlying linked list that stores the elements in the queue
    private MyLinkedList<T> queue;

    /**
     * Constructs a new, empty MyQueue object
     * 
     * Time complexity: O(1) - initializes the queue array with an empty linked list.
     */
    MyQueue(){
        queue = new MyLinkedList<>();
    }

    /**
     * Returns true if the queue is empty, and false otherwise
     * 
     * Time complexity: O(1) - checks if the size of the queue is zero.
     * 
     * @return True if the queue is empty, and false otherwise.
     */
    boolean empty(){
        return size() == 0;
    }

    /**
     * Returns the number of elements in the queue
     * 
     * Time complexity: O(1) - returns the size of the underlying linked list.
     * 
     * @return The number of elements in the queue.
     */
    int size(){
        return queue.size();
    }

    /**
     * Returns the first element in the queue without removing it
     * 
     * Time complexity: O(1) - returns the first element in the underlying linked list.
     * 
     * @return The first element in the queue.
     */
    T peek(){
        return queue.getFirst();
    }

    /**
     * Inserts an element into the queue
     * 
     * Time complexity: O(1) - adds the element to the end of the underlying linked list.
     * 
     * @param item The item to insert.
     * @return The inserted item.
     */
    T enqueue(T item){
        queue.addLast(item);
        return item;
    }

    /**
     * Removes and returns the first element in the queue
     * 
     * Time complexity: O(1) - removes and returns the first element in the underlying linked list.
     * 
     * @return The first element in the queue.
     */
    T dequeue(){
        T removed = queue.getFirst();
        queue.removeFirst();
        return removed;
    }
}
