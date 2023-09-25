import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(5, 6, 7);
        list.add(list1);
        list.add(list2);
        // 1 + 9 + 25 + 49 = 70
        // [1, 3, 5, 7]
//        Integer sum = list.stream().flatMap(e -> e.stream().filter(f -> f % 2 != 0).map(g -> g * g)).reduce(Integer::sum).orElse(0);
        List<Integer> flat = list.stream().flatMap(e -> e.stream()).collect(Collectors.toList());
        System.out.println(flat);
    }
}
