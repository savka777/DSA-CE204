package LinkedList;


public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(4,3);

//        System.out.println(list.isCycle());
        list.makeCycle(2);
        System.out.println(list.isCycle());





    }

}
