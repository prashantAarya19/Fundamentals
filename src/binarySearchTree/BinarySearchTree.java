package binarySearchTree;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BinarySearchTree {

    public static Node<Integer> takeInput(Node<Integer> rootNode) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter data in root");
        int data = sc.nextInt();

        while(-1 != data) {
            rootNode = getInsertIntoTree(rootNode, data);
            System.out.println("Enter data in child");
            data = sc.nextInt();
        }
        return rootNode;
    }

    public static Node<Integer> getInsertIntoTree(Node<Integer> rootNode, int data) {
        if(null == rootNode) {
            return new Node<>(data);
        }

        if(data > rootNode.data) {
            // Insert into right side
            rootNode.right = getInsertIntoTree(rootNode.right, data);
        } else {
            // Insert into left side
            rootNode.left = getInsertIntoTree(rootNode.left, data);
        }
        return rootNode;
    }

    public static void levelOrderTraversal(Node<Integer> rootNode) {
        Queue<Node<Integer>> queue = new LinkedList<>();
        queue.add(rootNode);
        queue.add(null);

        while(!queue.isEmpty()) {
            Node<Integer> tempNode = queue.remove();

            if(tempNode == null) {
                System.out.println();
                if(!queue.isEmpty()) {
                    queue.add(null);
                }
            } else {
                System.out.print(tempNode.data +" ");
                if(null != tempNode.left) {
                    queue.add(tempNode.left);
                }

                if(null != tempNode.right) {
                    queue.add(tempNode.right);
                }
            }
        }
    }

    public static void inorderTraversal(Node<Integer> rootNode) {
        if(null == rootNode) {
          return;
        }
        inorderTraversal(rootNode.left);
        System.out.print(rootNode.data+" ");
        inorderTraversal(rootNode.right);
    }

    public static void main(String[] args) {
        Node<Integer> binarySearchTree = takeInput(null);
        System.out.println("***Inorder traversal");
        inorderTraversal(binarySearchTree);
        System.out.println("\n***Level order traversal");
        levelOrderTraversal(binarySearchTree);
    }

}
