package linkedList;

public class DoublyLinkedList <T>{
    private DoublyNode<T> head;
    private DoublyNode<T> tail;
    private int size = 0;

    public void addAtFirst(T data) {
        if(null == this.head) {
            this.head = new DoublyNode<>(data);
            this.tail = head;
            ++size;
            return;
        }

        DoublyNode<T> newNode = new DoublyNode<>(data);
        this.head.previous = newNode;
        newNode.next = head;
        this.head = newNode;
        ++size;
    }
    public void addAtLast(T data) {
        if(null == head) {
            this.head = new DoublyNode<>(data);
            this.tail = head;
            ++size;
            return;
        }

        DoublyNode<T> newNode = new DoublyNode<>(data);
        newNode.previous = tail;
        tail.next = newNode;
        tail = newNode;
        ++size;
    }

    public void removeFirst() {
        head = head.next;
        --size;
    }

    public void removeLast() {
        tail = tail.previous;
        tail.next = null;
        --size;
    }

    public void insertAtPosition(int index, T data) {
        DoublyNode<T> newNode = new DoublyNode<>(data);
        if(head == null || tail == null) {
               head = newNode;
               tail = head;
               ++size;
               return;
        }
        DoublyNode<T> tempNode = head;
        int counter = 1;
        while(counter < index - 1) {
            tempNode = tempNode.next;
            ++counter;
        }

        newNode.previous = tempNode;
        newNode.next = tempNode.next;
        tempNode.next = newNode;
        ++size;
    }

    public int getSize() {
        return this.size;
    }


    public void printList() {
        DoublyNode<T> tempNode = head;
        while (tempNode != null) {
            System.out.print(tempNode.data+" ");
            tempNode = tempNode.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
//        doublyLinkedList.addAtFirst(12);
//        doublyLinkedList.addAtFirst(13);
//        doublyLinkedList.addAtFirst(14);
//        doublyLinkedList.addAtLast(25);
        System.out.println("Size : "+ doublyLinkedList.getSize());
        doublyLinkedList.printList();
       // doublyLinkedList.removeLast();
       // doublyLinkedList.printList();
        doublyLinkedList.insertAtPosition(1, 55);
        doublyLinkedList.insertAtPosition(2, 66);
        System.out.println("Size : "+ doublyLinkedList.getSize());
        doublyLinkedList.printList();
    }
}
