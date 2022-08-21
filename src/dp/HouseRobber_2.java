package dp;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber_2 {
    int[] nums;
    Map<Integer, Integer> memo=new HashMap<>();

    public int rob(int[] nums) {
        this.nums=nums;
        return dp(this.nums.length-1);
    }

    private int dp(int index) {
        if(index==0) return this.nums[0];
        if(index==1) return Math.max(this.nums[0], this.nums[1]);

        if(!memo.containsKey(index)) {
            memo.put(index, Math.max(dp(index-1), dp(index-2)+this.nums[index]));
        }

        return memo.get(index);
    }
}
