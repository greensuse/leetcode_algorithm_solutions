package hash_table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArrays_2 {
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
            int count=map.getOrDefault(n,0);
            if(count>0) {
                overlap.add(n);
                map.put(n, count-1);
            }
        }

        int[] res=new int[overlap.size()];
        int i=0;
        for(int n: overlap) {
            res[i++]=n;
        }
        return res;
    }
}
