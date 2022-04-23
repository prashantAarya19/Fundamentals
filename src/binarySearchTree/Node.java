package binarySearchTree;

public class Node<T> {
    T data;
    Node<T> left;
    Node<T> right;

    public Node(T t) {
        this.data = t;
        this.left = null;
        this.right = null;
    }
}
