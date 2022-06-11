import java.util.Arrays;

public class MyStack {

//    push(Object value) добавляет элемент в конец
//    remove(int index) удаляет элемент под индексом
//    clear() очищает коллекцию
//    size() возвращает размер коллекции
//    peek() возвращает первый элемент в стеке (LIFO)
//    pop() возвращает первый элемент в стеке и удаляет его из коллекции

    private Object[] array = new Object[0];

    public int size() {
        int s = 0;
        for (Object element: array) {
            if (element != null) {
                s++;
            }
            continue;
        }
        return s;
    }

    private Object[] grow() {
        Object[] arrTarget = Arrays.copyOf(array, array.length+1);
        array = arrTarget;
        return array;
    }

    public void push(Object newObj){
        if(size() == array.length) {
            this.grow();
        }
        array[this.size()] = newObj;
    }

    public Object remove(int index) {
        if(index > size() || index < 0) {
            System.out.println("Incorrect index! Please enter a correct index");
            return index;
        }
        Object element = array[index];
        System.arraycopy(array, index +1, array, index,size() - index - 1);
        Object[] arrTarget = Arrays.copyOf(array, array.length-1);
        array = arrTarget;
        return element;
    }

    public void clear() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
        Object[] arrTarget = Arrays.copyOf(array, 0);
        array = arrTarget;
    }

    public Object peek(){
        Object res = null;
        if(size() > 0 ) {
            res = array[size() - 1];
        }
        return res;
    }

    public Object pop(){
        Object res = null;
        if(size() > 0 ) {
            res = array[size() - 1];
            remove(size() - 1);
        }
        return res;
    }



    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
