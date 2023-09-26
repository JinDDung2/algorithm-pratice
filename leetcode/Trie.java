package leetcode;

/**
 * 208. Implement Trie (Prefix Tree)
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

public class Trie {
    class Node {
        Node[] nexts = new Node[26];
        String word;
    }

    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;

        for (char c : word.toCharArray()) {
            if (node.nexts[c - 'a'] == null) {
                node.nexts[c - 'a'] = new Node();
            }
            node = node.nexts[c - 'a'];
        }

        node.word = word;
    }

    public boolean search(String word) {
        Node node = root;

        for (char c : word.toCharArray()) {
            if (node.nexts[c - 'a'] == null) {
                return false;
            }
            node = node.nexts[c - 'a'];
        }

        return node.word != null;
    }

    public boolean startsWith(String prefix) {
        Node node = root;

        for (char c : prefix.toCharArray()) {
            if (node.nexts[c - 'a'] == null) {
                return false;
            }
            node = node.nexts[c - 'a'];
        }

        return true;
    }
}
