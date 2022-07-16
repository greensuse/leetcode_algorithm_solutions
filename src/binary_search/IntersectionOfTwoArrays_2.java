package binary_search;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays_2 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        Set<Integer> set=new HashSet<>();
        int i=0, j=0;

        while(i<nums1.length && j<nums2.length) {
            if(nums1[i]==nums2[j]) {
                set.add(nums1[i]);
                i++;
                j++;
            } else if(nums1[i]<nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] ans=new int[set.size()];
        int k=0;
        for(int val : set) {
            ans[k++]=val;
        }

        return ans;
    }
}
