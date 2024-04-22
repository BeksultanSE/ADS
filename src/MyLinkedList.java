import java.util.Iterator;

public class MyLinkedList<E extends Comparable<E>> implements MyList<E> {
    private MyNode<E> head;
    private MyNode<E> tail;
    private int size;
    public MyLinkedList(){

    }
    @Override
    public void add(E item) {
        addLast(item);
    }

    @Override
    public void set(int index, E item) {
        checkIndex(index);
        MyNode<E> current = getNode(index);
        current.data = item;
    }

    @Override
    public void add(int index, E item) {
        if(index == 0){
            addFirst(item);
        }
        else if(index == size){
            addLast(item);
        }
        else{
            checkIndex(index);
            MyNode<E> prev = getNode(index - 1);
            MyNode<E> newNode = new MyNode<>(item);
            newNode.next = prev.next;
            prev.next = newNode;
            newNode.prev = prev;
            if (newNode.next != null) {
                newNode.next.prev = newNode;
            } else {
                tail = newNode;
            }
            size++;
        }
    }

    @Override
    public void addFirst(E item) {
        MyNode<E> newNode = new MyNode<>(item);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(E item) {
        MyNode<E> newNode = new MyNode<>(item);
        if(tail == null){
            tail = newNode;
            head = newNode;
        }
        else{
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        MyNode<E> current = getNode(index);
        return current != null ? current.data : null;
    }

    @Override
    public E getFirst() {
        return head != null ? head.data : null;
    }

    @Override
    public E getLast() {
        return tail != null ? tail.data : null;
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        MyNode<E> current = getNode(index);
        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev;
        }
        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            head = current.next;
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
        boolean swapped;
        do {
            swapped = false;
            MyNode<E> current = head;
            while (current.next != null) {
                if (current.data.compareTo(current.next.data) > 0) {
                    E temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    @Override
    public int indexOf(Object object) {
        MyNode<E> current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(object)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        MyNode<E> current = tail;
        int index = size - 1;
        while (current != null) {
            if (current.data.equals(object)) {
                return index;
            }
            current = current.prev;
            index--;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        MyNode<E> current = head;
        for (int i = 0; i < size; i++) {
            array[i] = current.data;
            current = current.next;
        }
        return array;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyLinkedListIterator<>();
    }

    private void checkIndex(int index) {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index not correct");
    }
    private MyNode<E> getNode(int index) {
        if (index >= 0 && index < size) {
            MyNode<E> current;
            if (index < size / 2) {
                current = head;
                for (int i = 0; i < index; i++) {
                    current = current.next;
                }
            } else {
                current = tail;
                for (int i = size - 1; i > index; i--) {
                    current = current.prev;
                }
            }
            return current;
        } else {
            return null;
        }
    }
    private static class MyNode<E>{
        E data;
        MyNode<E> next;
        MyNode<E> prev;
        MyNode(E data){
            this.data = data;
        }
    }
    private class MyLinkedListIterator<E> implements Iterator<E>{
        private MyNode<E> current;

        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public E next() {
            if(!hasNext()){
                return null;
            }
            E data = current.data;
            current = current.next;
            return data;
        }
    }
}
