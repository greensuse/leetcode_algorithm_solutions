package hash_table;

import java.util.*;

public class IntersectionOfTwoArrays_1 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length) {
            return intersect(nums2, nums1);
        }

        Map<Integer, Integer> map=new HashMap<>(nums1.length);

        for(int n : nums1) {
            map.put(n, map.getOrDefault(n, 0)+1);
        }

        List<Integer> overlap=new ArrayList<>();
        for(int n : nums2) {
            if(map.getOrDefault(n,0)>0) {
                overlap.add(n);
                map.put(n, map.get(n)-1);
            }
        }

        int[] res=new int[overlap.size()];
        for(int i=0; i<overlap.size(); i++) {
            res[i]=overlap.get(i);
        }
        return res;
    }
}
