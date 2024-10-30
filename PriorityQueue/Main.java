package PriorityQueue;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();

        pQueue.insert(10,5);
        pQueue.insert(3,1);
        pQueue.insert(1,3);
        pQueue.insert(5,4);
        pQueue.insert(5,2);

        pQueue.print();
        System.out.println("Data removed: " + pQueue.poll());
        System.out.println("Data removed: " + pQueue.poll());
        System.out.println("Data removed: " + pQueue.poll());
        System.out.println("Data removed: " + pQueue.poll());
        System.out.println("Data removed: " + pQueue.poll());

    }
}
