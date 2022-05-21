package array;

import java.util.Arrays;

public class MoveZeros_2 {

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeros(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeros(int[] nums) {
        for(int insertedIndex=0, cur=0; cur<nums.length; cur++) {
            if(nums[cur]!=0) {
                //do swap
                int temp = nums[cur];
                nums[cur]=nums[insertedIndex];
                nums[insertedIndex++]=temp;
            }
        }
    }
}
