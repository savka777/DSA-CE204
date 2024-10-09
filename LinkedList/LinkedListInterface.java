package LinkedList;
public interface LinkedListInterface<T> {
    void add(T data);
    void add(T data, int index);
    void remove(int index);
    T get(int index);
    int size();
    boolean isEmpty();
    void print();

}
