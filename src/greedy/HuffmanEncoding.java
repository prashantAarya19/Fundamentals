package greedy;

import java.util.ArrayList;
import java.util.PriorityQueue;

class Node implements Comparable<Node>{
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    @Override
    public int compareTo(Node p){

        if(this.data==p.data)
            return 1;
        return this.data-p.data;
    }
}
public class HuffmanEncoding {
    public ArrayList<String> huffmanCodes(String S, int f[], int N) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for(int i = 0; i < N; i++) {
            pq.add(new Node(f[i]));
        }

        while(pq.size() > 1) {
            Node left = pq.remove();
            Node right = pq.remove();

            Node newNode = new Node(left.data + right.data);
            newNode.left = left;
            newNode.right = right;
            pq.add(newNode);
        }

        ArrayList<String> result = new ArrayList<>();
        traverseAndEncode(result, "", pq.remove());
        return result;
    }

    private void traverseAndEncode(ArrayList<String> result, String code, Node root) {
        if(root.left == null && root.right == null) {
            result.add(code);
            return;
        }

        traverseAndEncode(result, code+"0", root.left);
        traverseAndEncode(result, code+"1", root.right);
    }
}
