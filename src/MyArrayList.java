import java.util.Arrays;

public class MyArrayList {
    private Object[] array = new Object[312];

    private Object[] grow() {
        Object[] arrTarget = Arrays.copyOf(array, array.length/2*3);
        array = arrTarget;
        return array;
    }

    public void add(Object value) {
    if(size() == array.length) {
        this.grow();
    }
    array[this.size()] = value;
    }

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

    public Object get(int index) {
        return array[index];
    }

    public Object remove(int index) {
        if(index > size() || index < 0) {
            System.out.println("Incorrect index! Please enter a correct index");
            return index;
        }
        Object element = array[index];
        System.arraycopy(array, index +1, array, index,size() - index - 1);
        array[size() - 1] = null;
        return element;
    }

    public void clear() {
        for (int i = 0  ; i < array.length; i++) {
            array[i] = null;
        }
    }


    @Override
    public String toString() {
        return Arrays.toString(array);
    }

}
