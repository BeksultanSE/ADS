public class MyMinHeap {
    // The underlying array that stores the items in the heap
    private MyArrayList<Integer> heap;

    /**
     * Constructs a new, empty MyMinHeap object
     * 
     * Time complexity: O(1) - initializes the heap array with a sentinel value.
     */
    MyMinHeap(){
        heap = new MyArrayList<>();
        heap.add(Integer.MIN_VALUE);
    }

    /**
     * This method prints the current heap tree in a human-readable format
     * 
     * Time complexity: O(n) - where n is the number of elements in the heap.
     */
    public void print()
    {
        for (int i = 1; i <= (heap.size() - 1) / 2; i++) {

            // Prints the parent and both childrens
            System.out.print(
                    " PARENT : " + heap.get(i)
                            + " LEFT CHILD : " + (leftChildOf(i) != Integer.MIN_VALUE ? heap.get(2 * i) : "Does not exist")
                            + " RIGHT CHILD :" + (rightChildOf(i) != Integer.MIN_VALUE ? heap.get(2 * i + 1) : "Does not exist"));

            // By here new line is required
            System.out.println();
        }
    }

    /**
     * Returns true if the heap is empty, and false otherwise
     * 
     * Time complexity: O(1) - checks if the heap array has only one element (the sentinel value).
     * 
     * @return True if the heap is empty, and false otherwise.
     */
    public boolean empty(){
        return (heap.size() == 1);
    }

    /**
     * Returns the number of elements in the heap
     * 
     * Time complexity: O(1) - returns the size of the heap array minus one (to exclude the sentinel value).
     * 
     * @return The number of elements in the heap.
     */
    public int size(){
        return heap.size() - 1;
    }

    /**
     * Returns the minimum element in the heap
     * 
     * Time complexity: O(1) - returns the first element in the heap array (which is always the minimum element).
     * 
     * @return The minimum element in the heap.
     */
    public int getMin(){
        return heap.get(1);
    }

    /**
     * Removes and returns the minimum element from the heap
     * 
     * Time complexity: O(log n) - where n is the number of elements in the heap.
     * 
     * @return The minimum element in the heap.
     */
    public int extractMin(){
        if(empty()){
            System.out.println("The Min Heap is empty!");
            return Integer.MIN_VALUE;
        }
        int popped = getMin();
        swap(1, size());
        heap.removeLast();
        heapify(1);
        return popped;
    }

    /**
     * Inserts an element into the heap
     * 
     * Time complexity: O(log n) - where n is the number of elements in the heap.
     * 
     * @param item The item to insert.
     */
    public void insert(int item){
        heap.addLast(item);
        traverseUp(size());
    }

    /**
     * Restores the heap property by "bubbling down" a node to its correct position in the heap
     * 
     * Time complexity: O(log n) - where n is the number of elements in the heap.
     * 
     * @param index The index of the node to start the heapify process from.
     */
    private void heapify(int index){
        if (leftChildOf(index) != Integer.MIN_VALUE && rightChildOf(index) != Integer.MIN_VALUE) {
            if (rightChildOf(index) == Integer.MIN_VALUE || (heap.get(leftChildOf(index)) <= heap.get(rightChildOf(index)))) {
                swap(leftChildOf(index), index);
                heapify(leftChildOf(index));
            }
            else {
                swap(rightChildOf(index), index);
                heapify(rightChildOf(index));
            }
        }
    }

    /**
     * Maintains the heap property by comparing the parent of a node with the node, and swapping them if the parent is greater than the node
     * 
     * Time complexity: O(log n) - where n is the number of elements in the heap.
     * 
     * @param index The index of the node to start the traverse up process from.
     */
    private void traverseUp(int index){
        if (index != 1 && heap.get(parentOf(index)) > heap.get(index)){
            swap(parentOf(index), index);
            traverseUp(parentOf(index));
        }
    }

    /**
     * Calculates the index of the left child of a node
     * 
     * Time complexity: O(1) - returns twice the index of the node.
     * 
     * @param index The index of the node.
     * @return The index of the left child of the node.
     */
    private int leftChildOf(int index) {
        return 2 * index;
    }

    /**
     * Calculates the index of the right child of a node
     * 
     * Time complexity: O(1) - returns twice the index of the node plus one.
     * 
     * @param index The index of the node.
     * @return The index of the right child of the node.
     */
    private int rightChildOf(int index){
        return 2 * index + 1;
    }

    /**
     * Calculates the index of the parent of a node
     * 
     * Time complexity: O(1) - returns the index of the node divided by two (rounded down).
     * 
     * @param index The index of the node.
     * @return The index of the parent of the node.
     */
    private int parentOf(int index){
        return index / 2;
    }

    /**
     * Swaps the elements at two indices in the heap array
     * 
     * Time complexity: O(1) - swaps the elements at the two indices.
     * 
     * @param index1 The index of the first element.
     * @param index2 The index of the second element.
     */
    private void swap(int index1, int index2){
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }
}
