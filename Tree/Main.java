package Tree;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> BST = new BinarySearchTree<Integer>();
        Integer[] arr = {7,10,15,14,2,1};

        for (Integer integer : arr) {
            BST.insert(integer);
        }
//        System.out.println(BST.getLength());
//        System.out.println(BST.search(1));
//        BST.inOrderTraversal();
//        BST.preOrderTraversal();
        BST.postOrderTraversal();
    }
}
