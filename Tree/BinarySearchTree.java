package Tree;

import java.lang.annotation.Native;

public class BinarySearchTree<T extends Comparable<T>> implements TreeADT<T> {

    private class Node {
        T data;
        Node left;
        Node right;

        public Node(T data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BinarySearchTree(){
        this.root = null;
        this.size = 0;
    }
    public int getLength(){
        return size;
    }
    @Override
    public void insert(T data){
        root = insertRecursive(root, data);
    }

    private Node insertRecursive(Node root, T data){
        if(root == null){
            root = new Node(data);
            size++;
        } else if (data.compareTo(root.data) < 0) {
            root.left = insertRecursive(root.left, data);
        } else if (data.compareTo(root.data) > 0) {
            root.right = insertRecursive(root.right,data);
        }else{
            throw new IllegalStateException("BST cannot have duplicates");
        }
        return root;
    }

    @Override
    public boolean search(T data){
        return searchRecursive(root, data);
    }

    public boolean searchRecursive(Node root, T data){
        if(root == null){
            return false;
        }
        if(data.compareTo(root.data) == 0){
            return true;
        }
        return data.compareTo(root.data) < 0 ? searchRecursive(root.left,data) : searchRecursive(root.right,data);
    }

    @Override
    public void inOrderTraversal() {
        inorderRecursive(root);
    }
    public void inorderRecursive(Node root){
        if(root !=null){
            inorderRecursive(root.left);
            System.out.println(root.data + " ");
            inorderRecursive(root.right);
        }

    }



}
