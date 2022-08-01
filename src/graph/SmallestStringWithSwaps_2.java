package graph;

import java.util.*;

public class SmallestStringWithSwaps_2 {
    public static void main(String[] args) {
        String s="dcabfg";
        List<List<Integer>> pairs=new ArrayList<>(2);
        List<Integer> list1=new ArrayList<>(2);
        list1.add(0);
        list1.add(3);
        List<Integer> list2=new ArrayList<>(2);
        list2.add(1);
        list2.add(2);
        pairs.add(list1);
        pairs.add(list2);

        String result=new SmallestStringWithSwaps_2().smallestStringWithSwaps(s, pairs);
        System.out.println(result);
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if(pairs.size()==0) return s;

        int len=s.length();
        PathCompressionOptimization unionFind=new PathCompressionOptimization(len);
        for(List<Integer> pair : pairs) {
            unionFind.union(pair.get(0), pair.get(1));
        }

        Map<Integer, PriorityQueue<Character>> map=new HashMap<>(len);
        for(int i=0; i<len; i++) {
            int root= unionFind.find(i);
            if(map.get(root)!=null) {
                map.get(root).offer(s.charAt(i));
            } else {
                PriorityQueue<Character> minHeap = new PriorityQueue<>();
                minHeap.offer(s.charAt(i));
                map.put(root, minHeap);
            }
        }

        StringBuilder sb=new StringBuilder();
        for(int i=0; i<len; i++) {
            int root= unionFind.find(i);
            sb.append(map.get(root).poll());
        }

        return sb.toString();
    }
}
