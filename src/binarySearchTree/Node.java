package binarySearchTree;

public class Node<T> {
    public T data;
    public Node<T> left;
    public Node<T> right;

    public Node(T t) {
        this.data = t;
        this.left = null;
        this.right = null;
    }
}
