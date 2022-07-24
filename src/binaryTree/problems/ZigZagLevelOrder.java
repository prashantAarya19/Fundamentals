package binaryTree.problems;

import binaryTree.Node;

import java.util.*;

public class ZigZagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(Node<Integer> root) {
        if(root == null) {
            return Collections.emptyList();
        }
        Queue<Node<Integer>> q = new LinkedList<>();
        q.add(root);
        boolean flag = false;
        List<List<Integer>> result = new ArrayList<>();
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> tempList = new ArrayList<>();
            int[] tempArr = new int[size];
            for(int i = 0; i < size; i++) {
                Node<Integer> temp = q.remove();
                int index = flag ? size - i - 1 : i;
                tempArr[index] = temp.data;

                if(temp.left != null) {
                    q.add(temp.left);
                }
                if(temp.right != null) {
                    q.add(temp.right);
                }
            }

            for(int i = 0; i < tempArr.length; i++) {
                tempList.add(tempArr[i]);
            }
            result.add(tempList);
            flag = !flag;
        }
        return result;
    }
}
