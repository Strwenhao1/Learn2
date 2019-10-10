package list;

import java.util.Arrays;

public class ArrayList implements List{
    private Object[] element;
    private int size;

    void checkRange(int i){
        if(i > size || i < 0){
            throw new RuntimeException();
        }
    }

    public ArrayList(){
        this(10);
    }

    public ArrayList(int initialCapacity) {
        this.element =new Object[initialCapacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object get(int i) {
        checkRange(i);
        return element[i];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object e) {

        return indexOf(e) != -1;
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < size ; i++){
            if (element[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void add(int i, Object e) {
        checkRange(i);
        for (int index = size ; index > i; index--){
            element[index] = element[index-1];
        }
        element[i] = e;
        size++;
    }

    @Override
    public void add(Object e) {
        add(size, e);

    }

    @Override
    public boolean addBefore(Object obj, Object e) {
        return false;
    }

    @Override
    public boolean addAfter(Object obj, Object e) {
        return false;
    }

    @Override
    public Object remove(int i) {
        return null;
    }

    @Override
    public boolean remove(Object e) {
        return false;
    }

    @Override
    public Object replace(int i, Object e) {
        return null;
    }

    @Override
    public Iterator iterator() {
        return new Itr();
    }

    class Itr<T> implements Iterator<T>{
        private int cursor = 0;
        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public T next() {
            int i = cursor;
            if(i== size){
                System.out.println("没有这个元素");
            }
            cursor++;

            return (T)element[i];
        }
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0 ; i < size ; i++){
            builder.append(element[i]+",");
        }
        builder.deleteCharAt(builder.length()-1);
        builder.append("]");
        return builder.toString();
    }
}
