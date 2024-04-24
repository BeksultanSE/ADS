import java.util.Iterator;
public class MyArrayList<T extends Comparable<T>> implements MyList<T> {
    private T[] arr;
    private int size;

    public MyArrayList(){
        arr = (T[]) new Comparable[5];
        size = 0;
    }
    private void increaseBuffer(){
        T[] newArr = (T[]) new Comparable[arr.length * 2];
        for (int i = 0; i < arr.length; i++){
            newArr[i] = arr[i];
        }
        arr = newArr;
    }
    private void checkIndex(int index) {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index not correct");
    }
    @Override
    public void add(T item) {
        add(size, item);
    }

    @Override
    public void set(int index, T item) {
        checkIndex(index);
        arr[index] = item;
    }
    @Override
    public void add(int index, T item) {
        if(size != index)
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

    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    @Override
    public void addLast(T item) {
        add(item);
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return arr[index];
    }

    @Override
    public T getFirst() {
        return arr[0];
    }

    @Override
    public T getLast() {
        return arr[size - 1];
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
    }

    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        remove(size - 1);
    }

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

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; --i) {
            if (arr[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return (indexOf(object) != -1);
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        for (int i = 0; i < size; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    @Override
    public void clear() {
        arr = (T[]) new Comparable[5];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyArrayListIterator();
    }
    private class MyArrayListIterator implements Iterator<T> {
        private int cursor;

        MyArrayListIterator(){
            cursor = 0;
        }

        @Override
        public boolean hasNext() {
            return (cursor < size);
        }

        @Override
        public T next() {
            if (!hasNext())
                return null;
            return arr[cursor++];
        }
    }
}
