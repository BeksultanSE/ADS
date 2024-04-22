public class Main {
    public static void main(String[] args) {
        MyList<Integer> list = new MyLinkedList<>();
        list.add(4);
        list.add(1);
        list.add(3);
        for (int i = 0; i < list.size(); i++){
            System.out.print(list.get(i).toString() + ' ');
        }
        System.out.println();
        list.sort();
        for (int i = 0; i < list.size(); i++){
            System.out.print(list.get(i).toString() + ' ');
        }
    }

}