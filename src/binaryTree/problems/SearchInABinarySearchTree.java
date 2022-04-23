package binaryTree.problems;

import binarySearchTree.*;

import binarySearchTree.Node;

public class SearchInABinarySearchTree extends BinarySearchTree {

    public static boolean search(Node<Integer> rootNode, int k) {
        Node<Integer> temp = rootNode;

        while(null != temp) {
            if(temp.data == k) {
                return true;
            }

            if(temp.data > k) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // 3 1 5 -1 2 -1 -1 -1 -1
        Node<Integer> rootNode = BinarySearchTree.takeInput(null);
        System.out.println(search(rootNode, 1));
    }
}
