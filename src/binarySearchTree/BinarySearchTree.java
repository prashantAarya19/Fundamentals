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

    public static int minValue(Node<Integer> rootNode) {
        Node<Integer> temp = rootNode;

        while(null != temp.left) {
            temp = temp.left;
        }
        return temp.data;
    }

    public static int mixValue(Node<Integer> rootNode) {
        Node<Integer> temp = rootNode;

        while(null != temp.right) {
            temp = temp.right;
        }
        return temp.data;
    }

    public static Node<Integer> deleteNode(Node<Integer> root, int k) {
        if(root == null) {
            return root;
        }
        if(root.data == k) {
            // 0 child
            if(root.left == null && root.right == null) {
                root.data = null;
                return root;
            }
            // left child
            if(null != root.left && null == root.right) {
                Node<Integer> temp = root.left;
                root.left = null;
                return temp;
            }else if(null == root.left) {
                Node<Integer> temp = root.right;
                root.right = null;
                return temp;
            } else {
                int min = minValue(root.right);
                root.data = min;
                root.right = deleteNode(root.right, min);
                return root;
            }
        } else if(root.data > k){
            root.left = deleteNode(root.left, k);
            return root;
        } else {
            root.right = deleteNode(root.right, k);
            return root;
        }
    }

    public static void main(String[] args) {
        Node<Integer> binarySearchTree = takeInput(null);
//        System.out.println("***Inorder traversal");
//        inorderTraversal(binarySearchTree);
        // 1, 3, 5, 6, 4
        System.out.println("\n***Level order traversal");
        levelOrderTraversal(binarySearchTree);
        deleteNode(binarySearchTree, 4);
        System.out.println("\n***after deletion");
        levelOrderTraversal(binarySearchTree);
    }

}