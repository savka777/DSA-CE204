package Queue;

public class Queue<T> implements QueueInterface<T>{
    class Node {
        Node next;
        T data;
        Node(T data){
            this.next = null;
            this.data = data;
        }
    }

    private Node front;
    private Node back;
    private int size;
    public Queue(){
        this.front = null;
        this.back = null;
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public void add(T data) {
        if(this.isEmpty()){
            front = back = new Node(data);
        }else{
            back.next = new Node(data);
            back = back.next;
        }
        size++;
    }
    @Override
    public void remove() {
        if(this.isEmpty()) throw new IllegalStateException("Queue is empty");

        if(front == back){
            front = back = null;
        }else{
            front = front.next;
        }
        size--;
    }
    @Override
    public T getBack(){
        if(this.isEmpty()) throw new IllegalStateException("Queue is empty");
        return this.back.data;
    }

    @Override
    public void print() {
        if(front == null) throw new IllegalStateException("Queue is empty or Index out of bound");
        System.out.println(front.data);
        front = front.next;
    }
}
