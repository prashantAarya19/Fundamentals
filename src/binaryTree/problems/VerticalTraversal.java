package binaryTree.problems;

import binaryTree.Node;

import java.util.*;
import java.util.AbstractMap.*;

public class VerticalTraversal {
    class Pair implements Comparable<Pair>{
        Integer hd;
        Node node;
        public Pair(int hd, Node node) {
            this.hd = hd;
            this.node = node;
        }


        @Override
        public int compareTo(Pair o) {
            return hd.compareTo(o.hd);
        }
    }
    public static void main(String[] args) {
        Queue<Map<Integer, Map<Integer, Queue<Integer>>>> q = new PriorityQueue<>();
        Map<Integer, Integer> m = new TreeMap<>();

    }

    public static ArrayList<Integer> verticalOrder(Node<Integer> root) {
        Map<Integer, Map<Integer, List<Integer>>>  nodes = new HashMap<>();
        Queue<SimpleEntry<Node<Integer>, SimpleEntry<Integer, Integer>>> q = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        // 1. Root is null return empty list
        if(root == null)
            return result;

        // 2. Push the root into queue
        q.add(new SimpleEntry<>(root, new SimpleEntry<>(0, 0)));

        // 3. Level order traversal of tree
        while(!q.isEmpty()) {
            SimpleEntry<Node<Integer>, SimpleEntry<Integer, Integer>> temp = q.remove();

            Node<Integer> frontNode = temp.getKey();
            int horizontalDistance = temp.getValue().getKey();
            int level = temp.getValue().getValue();
           // Adding data into the map
            List<Integer> data = new ArrayList<>();
            data.add(frontNode.data);
            Map<Integer, List<Integer>> levelOrderData = new HashMap<>();
            levelOrderData.put(level, data);
            nodes.put(horizontalDistance, levelOrderData);

            if(frontNode.left != null)
                q.add(new SimpleEntry<>(frontNode.left, new SimpleEntry<>(horizontalDistance - 1, level + 1)));

            if(frontNode.right != null)
                q.add(new SimpleEntry<>(frontNode.right, new SimpleEntry<>(horizontalDistance + 1, level + 1)));

        }
        for(Map.Entry<Integer, Map<Integer, List<Integer>>> a : nodes.entrySet()) {
            for(Map.Entry<Integer, List<Integer>> b : a.getValue().entrySet()) {
                result.addAll(b.getValue());
            }
        }
        return result;
    }
}
