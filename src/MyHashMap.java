import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class MyHashMap<K, V> {
    ObjectHashMap < K, V> [] hashArray;
    int size = 0;
    int capacity;
    static final int INITIAL_DEFAULT_CAPACITY= 8;

    public <K,V> MyHashMap(){
        this.capacity = INITIAL_DEFAULT_CAPACITY;
        this.hashArray = new ObjectHashMap[capacity];
    }

    public MyHashMap(int initialCapacity){
        this.capacity = initialCapacity;
        this.hashArray = new ObjectHashMap[capacity];
    }

    public void put(K key, V value ){
        ObjectHashMap<K,V> newElement = new ObjectHashMap(key, value);
        ObjectHashMap<K,V> temp = hashArray[counterInHashArray(newElement.hashCode())];
        if(temp == null){
            hashArray[counterInHashArray(newElement.hashCode())] = newElement;
            size++;
        } else{
            if(temp.next == null){
            } else {
            while (temp.next != null){
                if(temp.equals(newElement)){
                    newElement.next = temp.next;
                    temp = newElement;
                    break;
                }
                temp = temp.next;
                }
            }
            if(temp.equals(newElement)){
                temp.setValue(newElement.value);
            } else {
                temp.next = newElement;
                size++;
            }
        }
    }

    public void remove(Object key){
        ObjectHashMap<K,V> newElement = new ObjectHashMap(key, null);
        ObjectHashMap<K,V> temp = hashArray[counterInHashArray(newElement.hashCode())];
        if(temp == null){
            System.out.println("Element with key " + key + " does not exist");
        } else {
            if(temp.next == null){
                if (temp.equals(newElement)) {
                    temp.next = null;
                    hashArray[counterInHashArray(newElement.hashCode())] = null;
                    size--;
                } else {
                    System.out.println("Element with key " + key + " does not exist");
                }
            } else {
                if(temp.equals(newElement)){
                    hashArray[counterInHashArray(newElement.hashCode())]  = temp.next;
                    size--;
                    System.out.println("only one first time");

                }
                while (temp.next != null){
                    if(temp.next.equals(newElement)){
                        temp.next = temp.next.next;
                        size--;
                        break;
                    }
                    temp = temp.next;
                }
            }
        }
    }

    public void clear() {
        for (int i = 0; i < hashArray.length; i++) {
            hashArray[i] = null;
        }
        ObjectHashMap<K,V>[] arrTarget = Arrays.copyOf(hashArray, 0);
        hashArray = arrTarget;
        size = 0;
    }

    public V get(Object key){
        ObjectHashMap<K,V> newElement = new ObjectHashMap(key, null);
        ObjectHashMap<K,V> temp = hashArray[counterInHashArray(newElement.hashCode())];
        V res = null;
        if (temp != null) {
            if(temp.equals(newElement)){
                res = temp.getValue();
            } else {
                while (temp.next != null) {
                    if(temp.equals(newElement)){
                        res = temp.getValue();
                    }
                    temp = temp.next;
                }
                if(temp.equals(newElement)){
                    res = temp.getValue();
                }
            }
        }
        return res;
    }

    public int size() {
        return size;
    }

    public int counterInHashArray(int hash) {
        int counterInHashArray = hash % hashArray.length;
        while (hash > hashArray.length) {
            hash--;
        }
        return counterInHashArray;
    }


     static class ObjectHashMap<K, V> {
        private K key;
        private V value;
         ObjectHashMap<K,V> next;

         ObjectHashMap(K key, V value) {
            this.key = key;
            this.value = value;
        }
         public final K getKey() {
            return key;
        }
         public final V getValue() {
            return value;
        }
        public void setKey(K key){
             this.key = key;
        }
        public void setValue(V value){
             this.value = value;
        }
        public void setNext(ObjectHashMap<K,V> next){
             this.next = next;
        }

        @Override
        public boolean equals(Object o){
             if(this==o) {
                 return true;
             }
             if(o==null || getClass()!=o.getClass()) {
                 return false;
             }
             ObjectHashMap<?,?> other = (ObjectHashMap<?,?>) o;
             return key.equals(other.getKey());
        }
        @Override
         public final String toString() {
            return key + "=" + value;
        }
        @Override
         public int hashCode(){
            return Math.abs(Objects.hash(getKey()));
        }
    }
}
