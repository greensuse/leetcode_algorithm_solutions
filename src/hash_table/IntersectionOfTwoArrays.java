package hash_table;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for(int num : nums1) {
            set1.add(num);
        }

        Set<Integer> set2= new HashSet<>();
        for(int num : nums2) {
            set2.add(num);
        }

        set1.retainAll(set2);

        int[] res=new int[set1.size()];
        int index=0;
        for(int val : set1) {
            res[index++]=val;
        }
        return res;
    }
}
