package linkedList.problems;

import linkedList.Node;
import linkedList.SinglyLinkedList;

public class ReverseList {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addAtFirst(5);
        list.addAtFirst(4);
        list.addAtFirst(3);
        list.addAtFirst(2);
        list.addAtFirst(1);
        list.printLinkedList();

        Node<Integer> reverse = reverse(list.head);
        print(reverse);
    }

    private static void print(Node<Integer> reverse) {
        Node<Integer> temp = reverse;
        while(reverse != null) {
            System.out.print(reverse.data + " ");
            reverse = reverse.next;
        }
        System.out.println();
    }

    private static Node<Integer> reverse(Node<Integer> head) {
       // Node<Integer> current = null;
        Node<Integer> currentHead = head;
        Node<Integer> previous = null;

        while(currentHead != null) {
            Node<Integer> temp = currentHead.next;
            currentHead.next = previous;
            previous = currentHead;
            currentHead = temp;
        }
        return previous;
    }
}
