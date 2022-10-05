package trie;

import java.util.Locale;

public class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode('\0');
    }
    public void insertUtil(TrieNode root, String word) {
        if(word.length() == 0) {
            root.isTerminal = true;
            return;
        }

        int index = word.charAt(0) - 'A';
        TrieNode child;
        if(root != null && root.children[index] != null) {
            child = root.children[index];
        } else {
            child = new TrieNode(word.charAt(0));
            if(root != null)
                root.children[index] = child;
        }
        insertUtil(child, word.substring(1));
    }
    public void add(String word) {
        insertUtil(root, word.toUpperCase());
    }

    public boolean search(String word) {
        return searchUtil(root, word.toUpperCase());
    }

    private boolean searchUtil(TrieNode root, String word) {
        if(word.length() == 0)
            return root.isTerminal;

        int index = word.charAt(0) - 'A';
        TrieNode child;
        if(root != null && root.children[index] != null) {
            child = root.children[index];
        } else {
            return false;
        }
        return searchUtil(child, word.substring(1));
    }

    private boolean remove(String word) {
        return removeUtil(root, word.toUpperCase());
    }

    private boolean removeUtil(TrieNode root, String word) {
        if(word.length() == 0) {
            root.isTerminal = false;
            return true;
        }

        int index = word.charAt(0) - 'A';
        TrieNode child;

        if(root != null && root.children[index] != null) {
            child = root.children[index];
        } else {
            return false;
        }
        return removeUtil(child, word.substring(1));
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("Hello");
        trie.add("Hi");
        System.out.println("Is present : "+trie.search("Hi"));
        System.out.println("Is removed : "+trie.remove("Hiee"));
        System.out.println("Is present : "+trie.search("Hi"));
        String s = "abc";
        System.out.println(s.substring(2));
    }
}
