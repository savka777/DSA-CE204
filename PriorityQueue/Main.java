package PriorityQueue;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();

        pQueue.enqueue(10,5);
        pQueue.enqueue(3,1);
        pQueue.enqueue(1,3);
        pQueue.enqueue(5,4);
        pQueue.enqueue(5,2);

        pQueue.print();
        System.out.println("Data removed: " + pQueue.dequeue());
        System.out.println("Data removed: " + pQueue.dequeue());
        System.out.println("Data removed: " + pQueue.dequeue());
        System.out.println("Data removed: " + pQueue.dequeue());
        System.out.println("Data removed: " + pQueue.dequeue());

    }
}
