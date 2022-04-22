package binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BTPract {

    public static Node<Integer> createBinTree(Node<Integer> rootNode) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter data : ");
        int data = sc.nextInt();
        rootNode = new Node<>(data);

        if (data == -1) {
            return null;
        }

        System.out.println("Insert data at left of : " + data);
        rootNode.left = createBinTree(rootNode.left);
        System.out.println("Insert data at right of :" + data);
        rootNode.right = createBinTree(rootNode.right);

        return rootNode;
    }

    public static void levelOrderTraversal(Node<Integer> rootNode) {
        Queue<Node<Integer>> queue = new LinkedList<>();
        queue.add(rootNode);
        queue.add(null);

        while (!queue.isEmpty()) {
            Node<Integer> temp = queue.remove();
            if (temp == null) {
                System.out.println();
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            } else {
                System.out.print(temp.data + " ");
                if (null != temp.left) {
                    queue.add(temp.left);
                }

                if (null != temp.right) {
                    queue.add(temp.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        Node<Integer> binTree = createBinTree(null);
        levelOrderTraversal(binTree);
    }
}
