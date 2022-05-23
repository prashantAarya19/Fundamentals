package linkedList;

public class CircularLinkedList<T> {
    Node<T> end;
    public void addElement(T data) {
        Node<T> newNode = new Node<>(data);
        if (null == end) {
            this.end = newNode;
            this.end.next = this.end;
            return;
        }
        Node<T> temp = end.next;
        end.next= newNode;
        newNode.next = temp;
        end = newNode;
    }

    public void removeFirst() {
        end.next = end.next.next;
    }

    public void printList() {
        Node<T> tempNode = end;
        Node<T> tempEnd = end;
        do {
            System.out.print(tempNode.data+" ");
            tempNode = tempNode.next;
        } while(tempEnd != tempNode);
        System.out.println();
    }

    public static void main(String[] args) {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        list.addElement(10);
        list.addElement(12);
        list.addElement(13);
        list.addElement(14);
        list.printList();
    }

}
