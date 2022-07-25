package trie;

import java.util.HashMap;
import java.util.Map;

public class MapSum {
    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        int sum1=mapSum.sum("ap");
        System.out.println(sum1);
        mapSum.insert("app", 2);
        int sum2=mapSum.sum("ap");
        System.out.println(sum2);
        mapSum.insert("apex", 4);
        int sum3=mapSum.sum("ap");
        System.out.println(sum3);
        mapSum.insert("app", 5);
        int sum4=mapSum.sum("ap");
        System.out.println(sum4);
    }
    HashMap<String, Integer> map;
    TrieNode root;
    public MapSum() {
        map = new HashMap();
        root = new TrieNode();
    }
    public void insert(String key, int val) {
        int delta = val - map.getOrDefault(key, 0);
        map.put(key, val);
        TrieNode cur = root;
        cur.score += delta;
        for (char c: key.toCharArray()) {
            cur.children.putIfAbsent(c, new TrieNode());
            cur = cur.children.get(c);
            cur.score += delta;
        }
    }
    public int sum(String prefix) {
        TrieNode cur = root;
        for (char c: prefix.toCharArray()) {
            cur = cur.children.get(c);
            if (cur == null) return 0;
        }
        return cur.score;
    }

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap();
        int score;
    }
}
