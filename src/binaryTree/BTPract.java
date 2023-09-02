package binaryTree;

import java.util.Scanner;

public class BTPract {

    private static Node<Integer> buildBTInOrder() {
        System.out.println("enter the data: ");
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        Node<Integer> root = new Node<>(data);
        if(data == -1)
            return null;

        System.out.println("Enter data for inserting in left of: " + data);
        root.left = buildBTInOrder();
        System.out.println("Enter data for inserting in right of: " + data);
        root.right = buildBTInOrder();
        return root;
    }
    public static void main(String[] args) {
        Node<Integer> root = buildBTInOrder();
        BinaryTree.inorderTraversal(root);
    }
}
