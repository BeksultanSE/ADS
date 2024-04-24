public class Main {
    public static void main(String[] args) {
        MyMinHeap minHeap = new MyMinHeap();
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);
        System.out.println(minHeap.extractMin());
        minHeap.print();

    }

}