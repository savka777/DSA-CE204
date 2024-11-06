package LinkedList;
public interface LinkedListADT<T> {
    void add(T data);
    void add(T data, int index);
    void remove(int index);
    void remove(T data);
    T get(int index);
    int size();
    boolean isEmpty();
    boolean isCycle();
    void makeCycle(int index);
    void sort();
    void print();

}
