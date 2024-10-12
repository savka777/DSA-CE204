package Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<Integer>();
        queue.add(1);
        queue.add(2);
        queue.add(3);

//        for(int i = 0; i <= queue.length(); i++){
//            queue.print();
//        }
        queue.remove();
        queue.print();
    }
}
