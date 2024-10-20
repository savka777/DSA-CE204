package Tree;

import java.util.ArrayList;

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
        inorder(root);
    }

    @Override
    public void preOrderTraversal() {
        preOrder(root);
    }

    @Override
    public void postOrderTraversal() {
        postOrder(root);
    }

    public void inorder(Node root){
        //left, root, right
        if(root !=null){
            inorder(root.left);
            System.out.println(root.data + " ");
            inorder(root.right);
        }
    }

    public ArrayList<T> inorder(Node root, ArrayList<T> results){
        //left, root, right
        if(root !=null){
            inorder(root.left,results);
            results.add(root.data);
            inorder(root.right);
        }
        return results;
    }

    public void preOrder(Node root){
//        root ,left, right
        if(root != null){
            System.out.println(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void postOrder(Node root){
        //left, right, root
        if(root != null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.data + " ");
        }
    }

    public T findPredecessor(){ // Find largest in left sub-tree
        if(this.root == null || this.root.left == null){
            return null;
        }
        Node curr = this.root.left;
        while(curr.right != null){
            curr = curr.right;
        }
        return curr.data;
    }

    public T findSuccessor(){ // Find smallest in right sub-tree
        if(this.root == null || this.root.right == null){
            return null;
        }
        Node curr = this.root.right;
        while(curr.left != null){
            curr = curr.left;
        }
        return curr.data;
    }

    public boolean isBST(){ // InOrder traversal solution
        ArrayList<T> results = new ArrayList<T>();
        results = inorder(this.root, results);

        for(int i = 0; i < results.size()-1; i++){
            if(results.get(i).compareTo(results.get(i + 1)) > 0){
                return false;
            }
        }
        return true;
    }



}
