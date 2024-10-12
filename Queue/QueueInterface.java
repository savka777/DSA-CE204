package Queue;

public interface QueueInterface<T> {
    boolean isEmpty();
    int length();
    void add(T data);
    void remove();

    void print();
    T getBack();


}
