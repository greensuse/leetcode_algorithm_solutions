package map;

import java.util.HashSet;
import java.util.Set;

public class ContainDuplicates {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set=new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            int n = nums[i];
            if(set.contains(n)) return true;
            set.add(n);
            if(set.size()>k) {
                set.remove(nums[i-k]);
            }
        }

        return false;
    }
}
