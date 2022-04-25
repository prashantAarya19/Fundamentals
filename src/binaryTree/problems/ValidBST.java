package binaryTree.problems;

import binaryTree.Node;

public class ValidBST {
    public static boolean isValid(Node<Integer> root, int min, int max) {
        if(null == root) {
            return true;
        }

        if(root.data >= min && root.right.data <= max) {
            boolean left = isValid(root.left, min, root.data);
            boolean right = isValid(root.right, root.data, max);
            return left && right;
        } else {
            return false;
        }
    }
    public static boolean validateBST(Node<Integer> root) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        return isValid(root, min, max);
    }

}
