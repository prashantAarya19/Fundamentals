package binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree {

    public static Node<Integer> buildTree(Node<Integer> root) {
        System.out.println("Enter the data::");
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        root = new Node<>(data);

        if (data == -1) {
            return null;
        }

        System.out.println("Enter data for inserting in left of: " + data);
        root.left = buildTree(root.left);
        System.out.println("Enter data for inserting in right: " + data);
        root.right = buildTree(root.right);
        return root;
    }

    public static void levelOrderTraversal(Node<Integer> root) {
        Queue<Node<Integer>> queue = new LinkedList<>();
        queue.add(root);
        // for formatting to a tree
        queue.add(null);

        while (!queue.isEmpty()) {
            Node<Integer> temp = queue.remove();
            if (temp == null) {
                System.out.println();
                if (!queue.isEmpty())
                    queue.add(null);
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

    public static void inorderTraversal(Node<Integer> rootNode) {
        if(rootNode == null) {
            return;
        }

        inorderTraversal(rootNode.left); // L
        System.out.print(rootNode.data +" "); // N
        inorderTraversal(rootNode.right); // R
    }

    public static void preOrderTraversal(Node<Integer> rootNode) {
        if(rootNode == null) return;

        System.out.print(rootNode.data+" ");
        preOrderTraversal(rootNode.left);
        preOrderTraversal(rootNode.right);
    }

    public static void postOrderTraversal(Node<Integer> rootNode) {
        if(rootNode == null) return;

        postOrderTraversal(rootNode.left);
        postOrderTraversal(rootNode.right);
        System.out.print(rootNode.data+" ");
    }

    public static void main(String[] args) {
        Node<Integer> root = buildTree(null);
        //levelOrderTraversal(root);
        System.out.println("***Inorder traversal [LNR]***");
        inorderTraversal(root);
        System.out.println("\n ***Preorder traversal [NLR]***");
        preOrderTraversal(root);
        System.out.println("\n ***Postorder traversal [LRN]***");
        postOrderTraversal(root);
    }
}
