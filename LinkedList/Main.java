package LinkedList;


public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.add(3);
        list.add(6);
        list.add(3);
        list.add(4,3);

//        System.out.println(list.isCycle());
//        list.makeCycle(2);
//        System.out.println(list.isCycle());
        list.print();
        System.out.println("\nAfter sorting sorting");
        list.sort();
        list.print();





    }

}
