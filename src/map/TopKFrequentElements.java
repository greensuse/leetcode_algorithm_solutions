package map;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map=new HashMap<>();

        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0)+1);
        }

        Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b)->b.getValue()-a.getValue());
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.add(entry);
        }

        int[] res=new int[k];
        for(int i=0; i<k; i++) {
            res[i] = queue.poll().getKey();
        }

        return res;
    }
}
