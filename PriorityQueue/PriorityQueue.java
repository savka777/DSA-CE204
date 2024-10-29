package PriorityQueue;

import java.util.ArrayList;

public class PriorityQueue<T> implements PriorityQueueADT<T>{

    private class Item{
        T data;
        int priority;

        public Item(T d, int p){
            this.data = d;
            this.priority = p;
        }
    }
    private final ArrayList<Item> itemArrayList;
    int size = 0;
    public PriorityQueue(){
        itemArrayList = new ArrayList<Item>();
    }

    private int leftChild(int index){return(2 * index) + 1;}
    private int rightChild(int index){return(2*index) + 2;}
    private int parent(int index){return(index - 1) / 2;}
    private void swap(int index1, int index2){
        Item temp = itemArrayList.get(index1);
        itemArrayList.set(index1,itemArrayList.get(index2));
        itemArrayList.set(index2,temp);
    }
    private int smallestInFamily(int index){
        // left child = (2 * i) + 1
        // right child = (2 * i) + 2
        int left = leftChild(index);
        int right = rightChild(index);
        if(left >= size) return -1; // no child
        if(right >=size) return left; // only left child

        if(itemArrayList.get(left).priority < itemArrayList.get(right).priority){
            return left;
        }else{
            return right;
        }
    }

    @Override
    public void enqueue(T data, int priority) {
       int curr = size;
       Item newItem = new Item(data, priority);
       itemArrayList.add(size, newItem); // add item to last position
        size++;

       // sift-up
        while(curr > 0 && itemArrayList.get(curr).priority < itemArrayList.get(parent(curr)).priority){
            swap(curr, parent(curr));
            curr = parent(curr);
        }
    }

    @Override
    public T dequeue() {

        if(isEmpty()) throw new IllegalStateException("Priority Queue is Empty");

        Item next = itemArrayList.get(0);
        itemArrayList.set(0,itemArrayList.get(size-1));
        itemArrayList.remove(size-1);
        size--;

        int curr = 0;

        while(true){
           int smallestChild = smallestInFamily(curr);
           if(smallestChild == -1) break;

           if(itemArrayList.get(curr).priority > itemArrayList.get(smallestChild).priority){
               swap(curr,smallestChild);
               curr = smallestChild;
           }else{
               break;
           }
        }
        return next.data;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    public void print(){
        for (Item item : itemArrayList) {
            System.out.println("Data: " + item.data+ ", Priority: " + item.priority);
        }
    }
}
