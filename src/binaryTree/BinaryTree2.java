package binaryTree;

import java.security.KeyPair;
import java.util.*;


public class BinaryTree2 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        // 1 3 7 -1 -1 11 -1 -1 5 17 -1 -1 -1
        // 1 3 5 7 11 17 -1 -1 -1 -1 -1 -1 -1
        Node<Integer> root = buildTreeWithLevelOrder();
        System.out.println("\n ***Inorder Traversal***");
        inorderTraversal(root);
        System.out.println("\n ***Preorder Traversal***");
        preOrderTraversal(root);
        System.out.println("\n ***Postorder Traversal***");
        postOrderTraversal(root);
        System.out.println("\n ***Moris Traversal***");
        morisTraversal(root);
        sc.close();
        /*
        ***Inorder Traversal***
        7 3 11 1 17 5
         ***Preorder Traversal***
        1 3 7 11 5 17
         ***Postorder Traversal***
        7 11 3 17 5 1
         */

    }

    public static void inorderTraversal(Node<Integer> root) {
        if(root == null || root.data == -1) {
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }

    public static void preOrderTraversal(Node<Integer> root) {
        if(root == null || root.data == -1) {
            return;
        }
        System.out.print(root.data+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static void postOrderTraversal(Node<Integer> root) {
        if(root == null || root.data == -1) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data+" ");
    }

    /** BFS ***/
    private static void levelOrderTraversal(Node<Integer> root) {
        Queue<Node<Integer>> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()) {
            Node<Integer> temp = q.remove();
            if(temp == null) {
                System.out.println();
                if(!q.isEmpty()) {
                    q.add(null);
                }
            } else {
                if(temp.data != -1)
                    System.out.print("   "+temp.data);
                if(temp.left != null) {
                    q.add(temp.left);
                }
                if(temp.right != null) {
                    q.add(temp.right);
                }
            }
        }
    }

    /** BFS ***/
    private static void reverseLevelOrderTraversal(Node<Integer> root) {
        Queue<Node<Integer>> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()) {
            Node<Integer> temp = q.remove();
            if(temp == null) {
                System.out.println();
                if(!q.isEmpty()) {
                    q.add(null);
                }
            } else {
                if(temp.data != -1)
                    System.out.print("   "+temp.data);
                if(temp.right != null) {
                    q.add(temp.right);
                }
                if(temp.left != null) {
                    q.add(temp.left);
                }
            }
        }
    }

    /** Inorder **/
    private static void morisTraversal(Node<Integer> root) {
        if(root == null)
            return;

        Node<Integer> current = root;
        Node<Integer> predecessor;

        while(current != null) {
            if(current.left == null) {
                System.out.print(current.data+" ");
                current = current.right;
            } else {
                predecessor = current.left;
                while(predecessor.right != null && predecessor.right != current)
                    predecessor = predecessor.right;

                if(predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;
                } else {
                    predecessor.right = null;
                    System.out.print(current.data+" ");
                    current = current.right;
                }
            }
        }
    }
    private static Node<Integer> buildTree() {
        System.out.println("Enter data: ");
        int val = sc.nextInt();
        Node<Integer> root = new Node<>(val);
        if(val == - 1)
            return root;
        System.out.println("***Enter left node of "+val+"***");
        root.left = buildTree();
        System.out.println("***Enter right node of "+val+"***");
        root.right = buildTree();
        return root;
    }

    private static Node<Integer> buildTreeWithLevelOrder() {
        Queue<Node<Integer>> q = new LinkedList<>();
        System.out.println("Enter data for root ");
        int d = sc.nextInt();
        Node<Integer> root = new Node<>(d);
        q.add(root);
        while(!q.isEmpty()) {
            Node<Integer> temp = q.remove();
            System.out.println("Enter data in left of : "+temp.data);
            int ld = sc.nextInt();
            if(ld != -1) {
                temp.left = new Node<>(ld);
                q.add(temp.left);
            }

            System.out.println("Enter data in right of : "+temp.data);
            int rd = sc.nextInt();
            if(rd != -1) {
                temp.right = new Node<>(rd);
                q.add(temp.right);
            }
        }
        return root;
    }
}
