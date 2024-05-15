import java.util.Iterator;
import java.util.Stack;

public class BST<K extends Comparable <K>, V> implements Iterable<BST.Node> {
    private Node root;
    private int size;
    class Node{
        private K key;
        private V value;
        private Node left, right;
        public Node (K key, V value){
            this.key = key;
            this.value = value;
            left = right = null;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
    public BST(){
        root = null;
    }
    public void put (K key, V value){
        root = put(root, key, value);
    }
    private Node put(Node root, K key, V value){
        if(root == null){
            root = new Node(key, value);
            return root;
        }
        if(key.compareTo(root.getKey()) < 0){
            root.setLeft(put(root.getLeft(), key, value));
        }
        else if(key.compareTo(root.getKey()) > 0){
            root.setRight(put(root.getRight(), key, value));
        }
        size++;
        return root;
    }
    public V get(K key){
        root = get(root, key);
        return root.getValue();
    }
    private Node get(Node root, K key){
        if (root == null || root.getKey() == key){
            return root;
        }
        if(key.compareTo(root.getKey()) < 0){
            return get(root.getLeft(), key);
        }
        else{
            return get(root.getRight(), key);
        }
    }
    public void delete(K key){
        root = delete(root, key);
    }
    private Node delete(Node root, K key){
        if(root == null)return root;

        if(key.compareTo(root.getKey()) < 0){
            root.setLeft(delete(root.getLeft(), key));
        }
        else if(key.compareTo(root.getKey()) > 0){
            root.setRight(delete(root.getRight(), key));
        }
        else{
            if(root.getLeft() == null) return root.getRight();
            if(root.getRight() == null) return root.getLeft();
            size--;
            root = minNode(root.getRight());
            root.setRight(delete(root.right, root.getKey()));
        }
        return root;
    }
    private Node minNode(Node root)  {
        while (root.getLeft() != null)  {
            root = root.getLeft();
        }
        return root;
    }
    public Iterable<Node> iterator(){
        return new InOrderIterator();
    }

    private class InOrderIterator implements Iterator<Node> {

        private Stack<Node> traversal;

        public InOrderIterator(){
            traversal = new Stack<>();
            moveLeft(root);
        }

        private void moveLeft(Node node){
            while(node != null){
                traversal.push(node);
                node = node.left;
            }
        }


        @Override
        public boolean hasNext() {
            return !traversal.isEmpty();
        }

        @Override
        public Node next() {
            if(!hasNext()){
                return null;
            }
            Node temp = traversal.pop();
            if(temp.getRight() != null){
                moveLeft(temp.getRight());
            }
            return temp;
        }
    }

    public int getSize() {
        return size;
    }

}
