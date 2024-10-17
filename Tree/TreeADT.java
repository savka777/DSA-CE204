package Tree;

public interface TreeADT<T> {
    void insert(T data);
    boolean search(T data); // Search for a node in the tree
    void inOrderTraversal(); // Traverse the tree in in-order
    void preOrderTraversal(); // Traverse the tree in pre-order
    void postOrderTraversal(); // Traverse the tree in post-order
//    boolean delete(T data); // Delete a node from the tree

}
