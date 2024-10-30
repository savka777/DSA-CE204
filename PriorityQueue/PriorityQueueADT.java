package PriorityQueue;

public interface PriorityQueueADT <T>{

    void insert(T item, int priority);
    T poll();
    boolean isEmpty();
    int size();

}
