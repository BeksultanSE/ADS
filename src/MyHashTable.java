public class MyHashTable <K, V>{
    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode <K, V> next;

        public HashNode(K key, V value){
            this.key = key;
            this.value = value;
        }
        public HashNode<K, V> getNext(){
            return next;
        }

        public void setNext(HashNode<K, V> node){
            this.next = node;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setKey(K key) {
            this.key = key;
        }
        public void setValue(V value){
            this.value = value;
        }
        public String toString(){
            return "{" + key + ": " + value + "}";
        }
    }
    private HashNode[] chainArray;
    private int M = 11;
    private int size;

    public MyHashTable(){
        chainArray = new HashNode[M];
        size = 0;
    }

    public MyHashTable(int M){
        this.M = M;
        chainArray = new HashNode[M];
        size = 0;
    }
    
    private int hash(K key){
        return Math.abs(key.hashCode()) % M;
    }

    public void put(K key, V value){
        int hash = hash(key);
        HashNode<K, V> head = chainArray[hash];

        while(head != null){
            if(head.getKey().equals(key)){
                head.setValue(value);
                return;
            }
            head = head.getNext();
        }

        HashNode<K, V> node = new HashNode<>(key, value);
        node.setNext(head);
        chainArray[hash] = node;
        size++;

        if ((1.0 * size) / M >= 0.7) {
            HashNode<K, V>[] temp = chainArray;
            M = 2 * M;
            chainArray = new HashNode[M];
            size = 0;
            for (HashNode<K, V> headNode : temp) {
                while (head != null) {
                    put(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }
    }

    public V get(K key){
        int index = hash(key);

        HashNode <K, V> head = chainArray[index];

        while(head != null && head.getKey() != key){
            head = head.getNext();
        }

        return head == null ? null : head.getValue();
    }

    public V remove(K key){
        int index = hash(key);
        HashNode<K, V> head = chainArray[index];
        HashNode<K, V> prev = null;

        while (head != null) {
            if (head.getKey().equals(key))
                break;

            prev = head;
            head = head.next;
        }
        if(head == null){
            return null;
        }

        if (prev != null)
            prev.next = head.next;
        else
            chainArray[index] = head.next;
        size--;

        return head.getValue();
    }

    public boolean contains(V value){
        for (HashNode<K, V> head : chainArray) {
            while (head != null) {
                if (head.getValue().equals(value)) {
                    return true;
                }
                head = head.getNext();
            }
        }
        return false;
    }

    public K getKey(V value){
        K key = null;
        for (HashNode<K, V> head : chainArray) {
            while (head != null) {
                if (head.getValue().equals(value)) {
                    key = head.getKey();
                    break;
                }
                head = head.getNext();
            }
        }
        return key;
    }
    public void print(){
        int i = 0;
        for(HashNode<K, V> node : chainArray){
            int count = 0;
            HashNode<K, V> head = node;
            while(head != null){
                count++;
                head = head.getNext();
            }
            i++;
            System.out.println(i + "th Bucket size: " + count);
        }
    }
}
