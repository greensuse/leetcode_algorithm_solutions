package binary_search_tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class ContainsDuplicateIII {
    public static void main(String[] args) {
        int[] nums = {1,2,1,1};
        int k=1, t=0;
        ContainsDuplicateIII obj=new ContainsDuplicateIII();
        boolean res = obj.containsNearbyAlmostDuplicate(nums, k, t);
        System.out.println(res);
    }
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> treeSet=new TreeSet<>();
        for(int i=0; i<nums.length; i++) {
            Long floor=treeSet.floor(Long.valueOf(nums[i]));
            if(floor!=null && nums[i]-floor<=t) return true;

            Long ceiling=treeSet.ceiling(Long.valueOf(nums[i]));
            if(ceiling!=null && ceiling-nums[i]<=t) return true;

            treeSet.add(Long.valueOf(nums[i]));
            if(treeSet.size()>k) {
                treeSet.remove(Long.valueOf(nums[i-k]));
            }
        }
        return false;
    }
}
