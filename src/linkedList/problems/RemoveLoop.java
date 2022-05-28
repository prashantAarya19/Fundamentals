package linkedList.problems;

import linkedList.Node;
import linkedList.SinglyLinkedList;

public class RemoveLoop {
    public static void removeLoop(Node<Integer> head) {
        if(head == null) {
            return;
        }

        Node<Integer> firstNode = getFirstNodeInLoop(head);
        if(firstNode == null) {
            return;
        }
        Node<Integer> tempNode = firstNode;

        while(tempNode.next != firstNode)
            tempNode = tempNode.next;

        tempNode.next = null;
    }

    public static Node<Integer> getFirstNodeInLoop(Node<Integer> head) {
        if(head == null) {
            return null;
        }
        // System.out.println("Inside getFirst");
        Node<Integer> fast = head;
        Node<Integer> slow = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) break;
        }

        if(fast != slow) return null;
        slow = head;
        while(fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addAtFirst(1);
        list.addAtFirst(2);
        list.addAtFirst(3);
        list.addAtFirst(4);
        list.addAtFirst(5);
        list.addAtFirst(6);
        list.head.next.next.next.next.next = list.head.next.next;
        removeLoop(list.head);
        list.printLinkedList();
    }
}
