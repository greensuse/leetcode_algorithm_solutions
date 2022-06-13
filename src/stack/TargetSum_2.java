package stack;

public class TargetSum_2 {
    public int findTargetSumWays(int[] nums, int target) {
        int count = calculate(nums, 0, 0, target);
        return count;
    }

    private int calculate(int[] nums, int index, int sum, int target) {
        if(index==nums.length) {
            return sum==target?1:0;
        }

        return calculate(nums, index+1, sum+nums[index], target) +
                calculate(nums, index+1, sum-nums[index], target);

    }
}
