public class MyStack<T extends Comparable<T>> {
    // The underlying linked list that stores the elements in the stack
    private MyLinkedList<T> stack;

    /**
     * Constructs a new, empty MyStack object
     * 
     * Time complexity: O(1) - initializes the stack array with an empty linked list.
     */
    MyStack(){
        stack = new MyLinkedList<>();
    }

    /**
     * Returns true if the stack is empty, and false otherwise
     * 
     * Time complexity: O(1) - checks if the size of the stack is zero.
     * 
     * @return True if the stack is empty, and false otherwise.
     */
    boolean empty(){
        return size() == 0;
    }

    /**
     * Returns the number of elements in the stack
     * 
     * Time complexity: O(1) - returns the size of the underlying linked list.
     * 
     * @return The number of elements in the stack.
     */
    int size(){
        return stack.size();
    }

    /**
     * Returns the first element in the stack without removing it
     * 
     * Time complexity: O(1) - returns the first element in the underlying linked list.
     * 
     * @return The first element in the stack.
     */
    T peek(){
        return stack.getFirst();
    }

    /**
     * Inserts an element into the stack
     * 
     * Time complexity: O(1) - adds the element to the beginning of the underlying linked list.
     * 
     * @param item The item to insert.
     * @return The inserted item.
     */
    T push(T item){
        stack.addFirst(item);
        return item;
    }

    /**
     * Removes and returns the first element in the stack
     * 
     * Time complexity: O(1) - removes and returns the first element in the underlying linked list.
     * 
     * @return The first element in the stack.
     */
    T pop(){
        T removed = stack.getFirst();
        stack.removeFirst();
        return removed;
    }
}
