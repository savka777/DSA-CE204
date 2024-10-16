package Stack;

public class Stack<T> implements StackADT<T> {

    private class Node{
        Node next;
        T data;

        public Node(T data){
            this.next = null;
            this.data = data;
        }
    }

    Node top = null;
    int size = 0;
    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public void push(T data) {
        Node newNode = new Node(data);
        if(top == null){
            top = newNode;
        }else{
            newNode.next = top;
            top = newNode;
        }
        size++;
    }
    @Override
    public T pop() {
        if (top == null) throw new IllegalStateException("Stack is empty or Index out of bounds");
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }
}
