package trie;

public class TrieNode {
    public   char data;
    public TrieNode[] children;
    public boolean isTerminal;

    public TrieNode(char data) {
        this.data = data;
        this.children = new TrieNode[25];
        this.isTerminal = false;
    }
}
