package exam;

public class StudentEntry<T,E> {
    private T key;
    private E value;



    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "StudentEntry{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
