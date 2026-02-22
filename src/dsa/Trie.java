package dsa;

import java.util.HashMap;
import java.util.Map;

/**
 * Trie (prefix tree) practical methods: insert, search, startsWith, delete.
 */
public class Trie {
    private static class Node {
        Map<Character, Node> next = new HashMap<>();
        boolean isWord;
    }

    private final Node root = new Node();

    public void insert(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            curr = curr.next.computeIfAbsent(c, k -> new Node());
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        Node node = walk(word);
        return node != null && node.isWord;
    }

    public boolean startsWith(String prefix) {
        return walk(prefix) != null;
    }

    public void delete(String word) {
        delete(root, word, 0);
    }

    private boolean delete(Node node, String word, int i) {
        if (i == word.length()) {
            if (!node.isWord) return false;
            node.isWord = false;
            return node.next.isEmpty();
        }
        char c = word.charAt(i);
        Node child = node.next.get(c);
        if (child == null) return false;
        boolean shouldDeleteChild = delete(child, word, i + 1);
        if (shouldDeleteChild) {
            node.next.remove(c);
            return !node.isWord && node.next.isEmpty();
        }
        return false;
    }

    private Node walk(String s) {
        Node curr = root;
        for (char c : s.toCharArray()) {
            curr = curr.next.get(c);
            if (curr == null) return null;
        }
        return curr;
    }
}
