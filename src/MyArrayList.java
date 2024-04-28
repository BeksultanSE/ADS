import java.util.Iterator;

public class MyArrayList<T extends Comparable<T>> implements MyList<T> {
    // The internal array that stores the items in the list
    private T[] arr;
    // The number of items in the list
    private int size;

    /**
     * Constructs a new, empty MyArrayList object.
     * 
     * Time complexity: O(1) - initializes the internal array and size variable.
     */
    public MyArrayList(){
        arr = (T[]) new Comparable[5];
        size = 0;
    }

    /**
     * Increases the capacity of the internal array by doubling its size.
     * 
     * Time complexity: O(n) - where n is the current size of the array.
     */
    private void increaseBuffer(){
        T[] newArr = (T[]) new Comparable[arr.length * 2];
        for (int i = 0; i < arr.length; i++){
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    /**
     * Throws an IndexOutOfBoundsException if the given index is out of bounds.
     * 
     * Time complexity: O(1) - checks if the index is within bounds.
     * 
     * @param index The index to check.
     */
    private void checkIndex(int index) {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index not correct");
    }

    /**
     * Adds an item to the end of the list.
     * 
     * Time complexity: O(1) - adds the item to the end of the list.
     * 
     * @param item The item to add.
     */
    @Override
    public void add(T item) {
        add(size, item);
    }

    /**
     * Sets the item at the given index to the specified value.
     * 
     * Time complexity: O(1) - sets the item at the specified index.
     * 
     * @param index The index to set.
     * @param item The item to set.
     */
    @Override
    public void set(int index, T item) {
        checkIndex(index);
        arr[index] = item;
    }

    /**
     * Inserts an item at the specified index.
     * 
     * Time complexity: O(n) - shifts elements to make room for the new item.
     * 
     * @param index The index to insert at.
     * @param item The item to insert.
     */
    @Override
    public void add(int index, T item) {
        if(size!= index)
            checkIndex(index);
        if (size == arr.length){
            increaseBuffer();
        }
        for (int i = size; i > index; i--){
            arr[i] = arr[i - 1];
        }
        arr[index] = item;
        size++;
    }

    /**
     * Adds an item to the beginning of the list.
     * 
     * Time complexity: O(n) - shifts elements to make room for the new item.
     * 
     * @param item The item to add.
     */
    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    /**
     * Adds an item to the end of the list.
     * 
     * Time complexity: O(1) - adds the item to the end of the list.
     * 
     * @param item The item to add.
     */
    @Override
    public void addLast(T item) {
        add(item);
    }

    /**
     * Returns the item at the specified index.
     * 
     * Time complexity: O(1) - returns the item at the specified index.
     * 
     * @param index The index to retrieve.
     * @return The item at the specified index.
     */
    @Override
    public T get(int index) {
        checkIndex(index);
        return arr[index];
    }

    /**
     * Returns the first item in the list.
     * 
     * Time complexity: O(1) - returns the first item in the list.
     * 
     * @return The first item in the list.
     */
    @Override
    public T getFirst() {
        return arr[0];
    }

    /**
     * Returns the last item in the list.
     * 
     * Time complexity: O(1) - returns the last item in the list.
     * 
     * @return The last item in the list.
     */
    @Override
    public T getLast() {
        return arr[size - 1];
    }

    /**
     * Removes the item at the specified index.
     * 
     * Time complexity: O(n) - shifts elements to fill the gap.
     * 
     * @param index The index to remove.
     */
    @Override
public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
    }

    /**
     * Removes the first item in the list.
     * 
     * Time complexity: O(n) - shifts elements to fill the gap.
     * 
     */
    @Override
    public void removeFirst() {
        remove(0);
    }

    /**
     * Removes the last item in the list.
     * 
     * Time complexity: O(1) - replaces the last item with null and decrements size.
     * 
     */
    @Override
    public void removeLast() {
        arr[size - 1] = null;
        size--;
    }

    /**
     * Sorts the list using a bubble sort algorithm.
     * 
     * Time complexity: O(n^2) - where n is the size of the list.
     * 
     */
    @Override
    public void sort() {
        for (int i = 0; i < size - 1; i++){
            for (int j = 0; j < size - i - 1; j++){
                if (arr[j].compareTo(arr[j + 1]) > 0){
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Returns the index of the first occurrence of the specified object.
     * 
     * Time complexity: O(n) - where n is the size of the list.
     * 
     * @param object The object to search for.
     * @return The index of the first occurrence of the specified object, or -1 if not found.
     */
    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified object.
     * 
     * Time complexity: O(n) - where n is the size of the list.
     * 
     * @param object The object to search for.
     * @return The index of the last occurrence of the specified object, or -1 if not found.
     */
    @Override
    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; --i) {
            if (arr[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns true if the specified object is in the list, and false otherwise.
     * 
     * Time complexity: O(n) - where n is the size of the list.
     * 
     * @param object The object to search for.
     * @return True if the specified object is in the list, and false otherwise.
     */
    @Override
    public boolean exists(Object object) {
        return (indexOf(object) != -1);
    }

    /**
     * Returns an array containing all of the items in the list.
     * 
     * Time complexity: O(n) - where n is the size of the list.
     * 
     * @return An array containing all of the items in the list.
     */
    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        for (int i = 0; i < size; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    /**
     * Clears the list, removing all items.
     * 
     * Time complexity: O(1) - resets the size and initializes a new array.
     * 
     */
    @Override
    public void clear() {
        arr = (T[]) new Comparable[5];
        size = 0;
    }

    /**
     *Returns the number of items in the list.
     * 
     * Time complexity: O(1) - returns the size variable.
     * 
     * @return The number of items in the list.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns an iterator for the list.
     * 
     * Time complexity: O(1) - returns a new iterator object.
     * 
     * @return An iterator for the list.
     */
    @Override
    public Iterator<T> iterator() {
        return new MyArrayListIterator();
    }

    /**
     * A private inner class that implements the Iterator interface.
     * 
     * Time complexity: O(1) - initializes the cursor variable.
     * 
     */
    private class MyArrayListIterator implements Iterator<T> {
        // The current position of the iterator
        private int cursor;

        /**
         * Constructs a new MyArrayListIterator object.
         * 
         * Time complexity: O(1) - initializes the cursor variable.
         * 
         */
        MyArrayListIterator(){
            cursor = 0;
        }

        /**
         * Returns true if there are more items to iterate over, and false otherwise.
         * 
         * Time complexity: O(1) - checks if the cursor is less than the size.
         * 
         * @return True if there are more items to iterate over, and false otherwise.
         */
        @Override
        public boolean hasNext() {
            return (cursor < size);
        }

        /**
         * Returns the next item in the iteration.
         * 
         * Time complexity: O(1) - returns the item at the current cursor position and increments the cursor.
         * 
         * @return The next item in the iteration.
         */
        @Override
        public T next() {
            if (!hasNext())
                return null;
            return arr[cursor++];
        }
    }
}
