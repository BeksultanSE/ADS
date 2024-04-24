public class MyStack<T extends Comparable<T>> {
    private MyLinkedList<T> stack;

    MyStack(){
        stack = new MyLinkedList<>();
    }

    boolean empty(){
        return size() == 0;
    }
    int size(){
        return stack.size();
    }

    T peek(){
        return stack.getFirst();
    }

    T push(T item){
        stack.addFirst(item);
        return item;
    }

    T pop(){
        T removed = stack.getFirst();
        stack.removeFirst();
        return removed;
    }
}
