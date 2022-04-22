package binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BinaryTree{

    public static Node<Integer> buildTree(Node<Integer> root) {
        System.out.println("Enter the data::");
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        root = new Node<>(data);

        if(data == -1) {
            return null;
        }

        System.out.println("Enter data for inserting in left of: "+data);
        root.left = buildTree(root.left);
        System.out.println("Enter data for inserting in right: "+data);
        root.right = buildTree(root.right);
        return root;
    }

    public static void levelOrderTraversal(Node<Integer> root) {
        Queue<Node<Integer>> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            Node<Integer> temp = queue.remove();
            System.out.print(temp.data +" ");
          //  queue.remove();

            if(null != temp.left) {
                queue.add(temp.left);
            }
            if(null != temp.right) {
                queue.add(temp.right);
            }
        }
    }

    public static void main(String[] args) {
        Node<Integer> root = buildTree(null);
        levelOrderTraversal(root);
    }
}
