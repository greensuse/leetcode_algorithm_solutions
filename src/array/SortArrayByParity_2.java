package array;

import java.util.Arrays;

public class SortArrayByParity_2 {
    public static void main(String[] args) {
        int[] nums = {3,1,2,4};
        sortArrayByParity(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static int[] sortArrayByParity(int[] nums) {
        if(nums.length==1) return nums;

        int lastInsertedIndex=0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]%2==0) {
                int temp = nums[lastInsertedIndex];
                nums[lastInsertedIndex]=nums[i];
                nums[i]=temp;
                lastInsertedIndex++;
            }
        }
        return nums;
    }
}
