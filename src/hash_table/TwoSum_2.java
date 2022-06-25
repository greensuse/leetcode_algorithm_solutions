package hash_table;

import java.util.HashMap;
import java.util.Map;

public class TwoSum_2 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            int num = nums[i];
            if(map.get(target-num)!=null) {
                return new int[]{ map.get(target-num), i};
            }
            map.put(nums[i], i);
        }

        return null;
    }
}
