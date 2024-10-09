package LinkedList;
public class LinkedList<T> implements LinkedListInterface<T>{
    public class Node {
        T data;
        Node next;
        public Node(T data){
            this.data = data;
            this.next = null;
        }
    }
    public Node head;
    public int size;
    public LinkedList(){
        this.head = null;
        this.size = 0;
    }

    @Override
    public void add(T data) {
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
        }else{
            Node curr = head;
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
        Node newNode = new Node(data);

        if(index == 0){
            newNode.next = head;
            head = newNode;
        }
        else{
            int curr_index = 0;
            Node curr = head;

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
            Node curr = head;
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
    public T get(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index out of bound");
        }

        int curr_index = 0;
        Node curr = head;
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
    public void print() {
        Node curr = head;
        while(curr != null){
            System.out.print(curr.data + " ->");
            curr = curr.next;
        }
    }
}
