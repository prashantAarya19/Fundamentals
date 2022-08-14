package heap.problems;

import binarySearchTree.BinarySearchTree;
import binarySearchTree.Node;

import java.util.ArrayList;
import java.util.List;

public class ConvertBSTToHeap {
    private static int index = 0;
    public static void main(String[] args) {
        Node<Integer> root = BinarySearchTree.takeInput(null);
        // Tree data : 4 2 1 3 6 5 7 -1
        System.out.println("<=== BST ===>");
        BinarySearchTree.levelOrderTraversal(root);
        List<Integer> inorderList = new ArrayList<>();
        getInOrder(root, inorderList);
        buildHeap(root, inorderList);
        System.out.println("<=== HEAP ===>");
        BinarySearchTree.levelOrderTraversal(root);
    }

    public static void getInOrder(Node<Integer> root, List<Integer> inorderList) {
        if(root == null)
            return;
        getInOrder(root.left, inorderList);
        inorderList.add(root.data);
        getInOrder(root.right, inorderList);
    }

    public static void buildHeap(Node<Integer> root, List<Integer> inorderList) {
        if(root == null || index >= inorderList.size())
            return;
        root.data = inorderList.get(index++);
        buildHeap(root.left, inorderList);
        buildHeap(root.right, inorderList);
    }
}
