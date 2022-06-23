package array_string;

public class MinSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE, left=0, sum=0;

        for(int i=0; i<nums.length; i++) {
            sum+=nums[i];

            while(sum>=target) {
                result=Math.min(result, i+1-left);
                sum-=nums[left];
                left++;
            }
        }

        return result!=Integer.MAX_VALUE?result:0;
    }
}
