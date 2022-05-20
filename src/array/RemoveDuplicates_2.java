package array;

import java.util.Arrays;

public class RemoveDuplicates_2 {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int result = removeDuplicates(nums);
        System.out.println(result + ":" + Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int insertedIndex=0;
        for(int j=1; j<nums.length; j++) {
            if(nums[j]!=nums[j-1]) {
                nums[++insertedIndex]=nums[j];
            }
        }
        return insertedIndex+1;
    }
}
