package PriorityQueue;

public interface PriorityQueueADT <T>{

    void enqueue(T item, int priority);
    T dequeue();
    boolean isEmpty();
    int size();

}
