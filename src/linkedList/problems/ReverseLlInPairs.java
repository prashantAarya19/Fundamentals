package linkedList.problems;

import linkedList.Node;
import linkedList.SinglyLinkedList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReverseLlInPairs {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
//        list.addAtFirst(5);
//        list.addAtFirst(4);
//        list.addAtFirst(3);
//        list.addAtFirst(2);
//        list.addAtFirst(1);
//        list.printLinkedList();
//        Node<Integer> reverse = reverse(list.head);
//        print(reverse);
        int h = 0;
       // int i = (h = list.hashCode()) ^ (h >>> 16);

        // 1705736037
        System.out.println(list.hashCode()); // 1705736037
        int[][] arr = new int[5][2];
        arr[0] = new int[]{1, 2};

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
        if(head == null)
            return null;

        if(head.next == null)
            return head;

        Node<Integer> prev = null;
        Node<Integer> forward = head;

        for(int i = 0; i < 2; i++) {
            Node<Integer> temp = forward.next;
            forward.next = prev;
            prev = forward;
            forward = temp;
        }

        head.next = reverse(forward);
        return prev;
    }

}
