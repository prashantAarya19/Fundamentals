package linkedList;

import java.util.ArrayList;
import java.util.List;

public class SinglyLinkedList<T> {
    public Node<T> head;
    private Node<T> tail;
    int size = 0;

    public void addAtFirst(int data) {
        ++size;
        if (head == null) {
            this.head = new Node(data);
            this.tail = head;
            return;
        }
        Node<T> temp = new Node(data);
        temp.next = head;
        head = temp;
    }

    public void removeFirst() {
        --size;
        head = head.next;
    }

    public void addAtEnd(int data) {
        ++size;
        Node<T> temp = new Node(data);
        if (head == null || tail == null) {
            this.head = temp;
            this.tail = temp;
            return;
        }
        tail.next = temp;
        tail = temp;
    }

    public void removeLast() {
        if (head == null)
            return;

        if (head.next == null) {
            return;
        }

        // Find the second last node
        Node<T> second_last = head;
        while (second_last.next.next != null)
            second_last = second_last.next;

        // Change next of second last
        second_last.next = null;
    }

    public void removeLast2() {
        Node<T> tempNode = head;
        int counter = 1;
        while (counter < size - 1) {
            tempNode = tempNode.next;
            ++counter;
        }
        tempNode.next = null;
        tail = tempNode;
    }

    public void printLinkedList() {
        Node<T> tempNode = head;
        while (tempNode != null) {
            System.out.print(tempNode.data + " ");
            tempNode = tempNode.next;
        }
        System.out.println(" ");
    }

    public void insetInBetween(int index, int data) {
        Node<T> tempNode = head;
        int counter = 1;
        if (size == 0) {
            addAtFirst(data);
            return;
        }
        if (index == 1) {
            Node<T> newNode = new Node(data);
            newNode.next = head;
            head = newNode;
            ++size;
            return;
        }
        if (index > size) {
            addAtEnd(data);
            return;
        }

        while (counter < index - 1) {
            tempNode = tempNode.next;
            ++counter;
        }
        Node<T> newNode = new Node(data);
        newNode.next = tempNode.next;
        tempNode.next = newNode;
        ++size;
    }

    public void deleteInBetween(int index) {
        Node<T> tempNode = head;
        int counter = 1;
        while(counter < index - 1) {
            tempNode = tempNode.next;
            ++counter;
        }
        tempNode.next = tempNode.next.next;

    }
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addAtEnd(4);
        list.addAtEnd(5);
        list.addAtEnd(7);
        list.addAtEnd(9);
        list.printLinkedList();
        // list.removeLast2();
       // list.insetInBetween(2, 32);
        list.deleteInBetween(2);
        list.printLinkedList();
    }
}
