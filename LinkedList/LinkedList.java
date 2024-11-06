package LinkedList;

import java.util.Comparator;

public class LinkedList<T extends Comparable<T>> implements LinkedListADT<T> {
    private class Node<T extends Comparable<T>> {
        T data;
        Node<T> next;
        public Node(T data){
            this.data = data;
            this.next = null;
        }
    }
    private Node<T> head;
    private int size;
    public LinkedList(){
        this.head = null;
        this.size = 0;
    }
    @Override
    public void add(T data) {
        Node<T> newNode = new Node<T>(data);

        if(head == null){
            head = newNode;
        }else{
            Node<T> curr = head;
            while(curr.next != null){
                curr = curr.next;
            }
            curr.next = newNode;
        }
        size++;
    }
    @Override
    public void add(T data, int index) {
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index out of bound");
        }
        Node<T> newNode = new Node<T>(data);

        if(index == 0){
            newNode.next = head;
            head = newNode;
        }
        else{
            int curr_index = 0;
            Node<T> curr = head;

            while(curr_index < index-1 && curr != null){
                curr = curr.next;
                curr_index ++;
            }
            newNode.next = curr.next;
            curr.next = newNode;
        }
        size++;

    }
    @Override
    public void remove(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index out of bound");
        }

        if(index == 0){
            head = head.next;
        }else{
            Node<T> curr = head;
            int curr_index = 0;

            while(curr_index < index -1){
                curr = curr.next;
                curr_index++;
            }
            curr.next = curr.next.next;
        }
        size--;
    }

    @Override
    public void remove(T data) {
        if(head == null) throw new IllegalStateException("List is empty");

        if(head.data.compareTo(data) == 0){
            head = head.next;
            return;
        }

        Node<T> curr = head;
        while(curr.next != null){
            if(curr.next.data.compareTo(data) == 0){
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }
    @Override
    public T get(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index out of bound");
        }

        int curr_index = 0;
        Node<T> curr = head;
        while(curr_index < index){
            curr = curr.next;
            curr_index++;
        }
        return curr.data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean isCycle() {
        if (head != null) {
            Node<T> fast = head;
            Node<T> slow = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void makeCycle(int index){
        if(head != null && index >= 0 || index < size){
            int curr_index = 0;
            Node<T> curr = head;

            while(curr_index < index){
                curr = curr.next;
                curr_index++;
            }
            if(curr == null){
                throw new IndexOutOfBoundsException("Index out of bound");
            }
            Node<T> cycleStart = curr;
            if(this.isCycle()){
                throw new IllegalStateException("List already has cycle");
            }

            Node<T> tail = cycleStart;
            while(tail.next != null){
                tail = tail.next;
            }
            tail.next = cycleStart;
        }else{
            throw new IndexOutOfBoundsException("Invalid index or empty list");
        }
    }
    @Override
    public void print() {
        Node<T> curr = head;
        while(curr != null){
            System.out.print(curr.data + " ->");
            curr = curr.next;
        }
    }

    public Node<T> findMin(){
        Node<T> minElem = this.head;
        Node<T> curr = this.head;

        while(curr.next != null){
            curr = curr.next;
            if(curr.data.compareTo(minElem.data) < 0) {
                minElem = curr;
            }
        }
        return minElem;
    }

    @Override
    public void sort(){
        LinkedList<T> sortedList = new LinkedList<T>();

        while(this.head != null){
            Node<T> min = this.findMin();
            sortedList.add(min.data);
            this.remove(min.data);
        }

        this.head = sortedList.head;
    }
}
