package Queue;

public interface QueueADT<T> {
    boolean isEmpty();
    int length();
    void add(T data);
    void remove();
    void print();
    T getBack();


}
