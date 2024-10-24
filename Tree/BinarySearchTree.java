package Tree;

import java.util.ArrayList;

public class BinarySearchTree<T extends Comparable<T>> implements TreeADT<T> {

    private class Node {
        T data;
        Node left;
        Node right;

        public Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    public int getLength() {
        return size;
    }

    @Override
    public void insert(T data) {
        root = insertRecursive(root, data);
    }

    private Node insertRecursive(Node root, T data) {
        if (root == null) {
            root = new Node(data);
            size++;
        } else if (data.compareTo(root.data) < 0) {
            root.left = insertRecursive(root.left, data);
        } else if (data.compareTo(root.data) > 0) {
            root.right = insertRecursive(root.right, data);
        } else {
            throw new IllegalStateException("BST cannot have duplicates");
        }
        return root;
    }

    @Override
    public boolean search(T data) {
        return searchRecursive(root, data);
    }

    public Node get(T data) {
        if (root == null) {
            return null;
        }
        Node curr = root;
        if (data == curr.data) {
            return curr;
        } else if (data.compareTo(curr.data) < 0) {
            curr = curr.left;
        } else {
            curr = curr.right;
        }
        return null;
    }

    public boolean searchRecursive(Node root, T data) {
        if (root == null) {
            return false;
        }
        if (data.compareTo(root.data) == 0) {
            return true;
        }
        return data.compareTo(root.data) < 0 ? searchRecursive(root.left, data) : searchRecursive(root.right, data);
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

    private void inorder(Node root) {
        //left, root, right
        if (root != null) {
            inorder(root.left);
            System.out.println(root.data + " " + numChildren(root));
            inorder(root.right);
        }
    }

    private ArrayList<T> inorder(Node root, ArrayList<T> results) {
        //left, root, right
        if (root != null) {
            inorder(root.left, results);
            results.add(root.data);
            inorder(root.right);
        }
        return results;
    }

    private void preOrder(Node root) {
//        root ,left, right
        if (root != null) {
            System.out.println(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    private void postOrder(Node root) {
        //left, right, root
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.data + " ");
        }
    }

    public boolean isBST() { // InOrder traversal solution
        ArrayList<T> results = new ArrayList<T>();
        results = inorder(this.root, results);

        for (int i = 0; i < results.size() - 1; i++) {
            if (results.get(i).compareTo(results.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }

    public int numChildren(Node root) {
        return (root.left == null ? 0 : 1) + (root.right == null ? 0 : 1);
    }

    public void invertTree() {
        this.root = invertTree(this.root);
    }

    private Node invertTree(Node root) {
        if (root == null) {
            return null;
        }
        Node tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);

        return root;

    }

    private Node findSuccessor(Node root){
        if(root == null){
            return null;
        }
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    @Override
    public void delete(T data) {
        delete(this.root,data);
    }

    private Node delete(Node root, T data){
        if(root == null){
            return null;
        }

        if(data.compareTo(root.data) < 0){
            root.left = delete(root.left, data);
        }else if(data.compareTo(root.data) > 0){
            root.right = delete(root.right,data);
        }else{
            // case 1, no children
            if(root.left == null && root.right == null){
                root = null;

                // case 2, right child
            } else if (root.left == null) {
                root = root.right;

                // case 3, left child
            } else if (root.right == null) {
                root = root.left;

                // case 4, right child
            }else{
                Node tmp = findSuccessor(root.right);
                root.data = tmp.data;
                root.right = delete(root.right,tmp.data);
            }
        }
        return root;

    }
}
