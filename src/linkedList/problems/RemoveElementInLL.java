package linkedList.problems;

import linkedList.Node;
import linkedList.SinglyLinkedList;

public class RemoveElementInLL {
    public static Node<Integer> removeElements(Node<Integer> head, int val) {
        if(head == null)
            return null;

        while(head.data != val)
            head = head.next;

        Node<Integer> forw = head;

        while(forw != null && forw.next != null) {
            if(forw.next.data == val)
                forw.next = forw.next.next;
            else
                forw = forw.next;
        }

        return head;
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addAtFirst(7);
        list.addAtFirst(7);
        list.addAtFirst(7);
        list.addAtFirst(7);
        list.addAtFirst(7);
        list.printLinkedList();

        Node<Integer> integerNode = removeElements(list.head, 7);
        print(integerNode);

    }

    private static void print(Node<Integer> reverse) {
        Node<Integer> temp = reverse;
        while(reverse != null) {
            System.out.print(reverse.data + " ");
            reverse = reverse.next;
        }
        System.out.println();
    }
}
