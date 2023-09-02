import java.util.*;

class Node {
    Node left, right;
    int data;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

public class Test extends RuntimeException {
    Node head = null;
    Node tail = null;

    void Nodeadd(int val) {
        Node newnode = new Node(val);

        if (tail == null) {
            tail = head = newnode;
            return;
        }

        newnode.left = tail;
        tail.right = newnode;
        tail = newnode;
    }

    Node bToDLL(Node root) {
        if (root == null) return null;

        bToDLL(root.left);
        Nodeadd(root.data);
        bToDLL(root.right);

        return head;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.fill(list, null);

        System.out.println(list.size());
    }
}
