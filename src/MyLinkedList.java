
import java.util.NoSuchElementException;

public class MyLinkedList<T> {
        Node<T> first;
        Node<T> last;
    private int size = 0;

   static class Node<E>{
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.prev = prev;
            this.item = element;
            this.next = next;
        }
    }

    public int sizeList(){
       return this.size;
    }

    public void add(T element) {
       Node<T> l = last;
        Node<T> newObjNode = new Node(l, element, first);
        last = newObjNode;
        if(l==null){
            first = newObjNode;
        } else {
            l.next = newObjNode;
        }
        size++;
    }

    public T remove(int index){
        Node<T> res = first;
        if(res == null || index > sizeList() || index < 0) {
            throw new NoSuchElementException();
        }
        for (int i = 0; i < index; i++) {
            res = res.next;
        }

        T element = res.item;
        Node<T> next = res.next;
        Node<T> prev = res.prev;

        if(prev == null) {
            first = next;
        } else {
            prev.next = next;
            res.prev = null;
        }

        if(next == null) {
            last = prev;
        } else {
            next.prev = prev;
            res.next = null;
        }
        res.item = null;
        size--;
        return element;
    }

    public T get(int index) {
        Node<T> res = first;
       if(res == null || index > sizeList() || index < 0) {
           throw new NoSuchElementException();
       }
        for (int i = 0; i < index; i++)
            res = res.next;
        return res.item;
    }

    public void clear() {
        for (Node<T> res = first; res != null; ) {
            Node<T> next = res.next;
            res.item = null;
            res.prev = null;
            res.next = null;
            res = next;
        }
            first = last = null;
            size = 0;

    }

}

