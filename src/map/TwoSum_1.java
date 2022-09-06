package map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {
    public static void main(String[] args) {
        int[] nums={3,3};
        int[] res = twoSum(nums, 6);
        System.out.println(Arrays.toString(res));
    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], i);
        }

        Integer index2=null;
        for(int i=0; i<nums.length; i++) {
            int num = nums[i];
            index2=map.get(target-num);

            if(index2!=null && i!=index2) {
                return new int[] {i, index2};
            }
        }

        return null;
    }
}
