public class MyMinHeap {
    private MyArrayList<Integer> heap;

    MyMinHeap(){
        heap = new MyArrayList<>();
        heap.add(Integer.MIN_VALUE);
    }
    // This method prints current heap tree
    public void print()
    {
        for (int i = 1; i <= (heap.size() - 1) / 2; i++) {

            // Printing the parent and both childrens
            System.out.print(
                    " PARENT : " + heap.get(i)
                            + " LEFT CHILD : " + (leftChildOf(i) != Integer.MIN_VALUE ? heap.get(2 * i) : "Does not exist")
                            + " RIGHT CHILD :" + (rightChildOf(i) != Integer.MIN_VALUE ? heap.get(2 * i + 1) : "Does not exist"));

            // By here new line is required
            System.out.println();
        }
    }
    public boolean empty(){
        return (heap.size() == 1);
    }
    public int size(){
        return heap.size() - 1;
    }

    public int getMin(){
        return heap.get(1);
    }

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

    public void insert(int item){
        heap.addLast(item);
        traverseUp(size());
    }

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

    private void traverseUp(int index){
        if (index != 1 && heap.get(parentOf(index)) > heap.get(index)){
            swap(parentOf(index), index);
            traverseUp(parentOf(index));
        }
    }

    private int leftChildOf(int index) {
        if (index * 2 > size()){
            return Integer.MIN_VALUE;
        }
        return index * 2;
    }

    private int rightChildOf(int index){
        if (index * 2 + 1 > size()){
            return Integer.MIN_VALUE;
        }
        return index * 2 + 1;
    }

    private int parentOf(int index){
        if (index / 2 < 1){
            return Integer.MIN_VALUE;
        }
        return (int)(index / 2);
    }

    private void swap(int index1, int index2){
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }
}
