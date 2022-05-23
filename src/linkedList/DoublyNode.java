package linkedList;

public class DoublyNode<T> {
    DoublyNode<T> previous;
    T data;
    DoublyNode<T> next;

    public DoublyNode(T data) {
        this.data = data;
    }

}
