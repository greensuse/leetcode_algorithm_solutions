package other;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LFUCache {
    private Map<Integer, Integer> valueMap=new HashMap<>();
    private Map<Integer, Integer> countMap=new HashMap<>();
    private TreeMap<Integer, List<Integer>> frequencyMap=new TreeMap<>();
    private final int size;

    public LFUCache(int capacity) {
        this.size = capacity;
    }

    public int get(int key) {
        return valueMap.get(key);
    }

    public void put(int key, int value) {}
}
