package array_string;

import java.util.Arrays;

public class ArrayPartition1 {
    public static void main(String[] args) {
        int[] nums = {1,4,3,2};
        int res = arrayPairSum(nums);
        System.out.println(res);
    }
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum=0;
        for(int i=0; i<nums.length; i=i+2) {
            sum+=nums[i];
        }
        return sum;
    }
}
