package LinkedList;


public class main {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(4,3);


        list.remove(0);
        System.out.println(list.get(0));
        list.print();
        System.out.println('\n');
        System.out.println(list.size);
        System.out.println(list.isEmpty());



    }

}
