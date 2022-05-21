package array;

import java.util.Arrays;

public class SortArrayByParity_1 {
    public static void main(String[] args) {
        int[] nums = {3,1,2,4};
        sortArrayByParity(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static int[] sortArrayByParity(int[] nums) {
        if(nums.length==1) return nums;

        int leftPointer=0, rightPointer=nums.length-1;

        while(leftPointer<rightPointer) {
            if(nums[leftPointer]%2==0){
                leftPointer++;
            }
            if(nums[rightPointer]%2==1){
                rightPointer--;
            }

            if(leftPointer<rightPointer && nums[leftPointer]%2==1 && nums[rightPointer]%2==0) {
                int temp=nums[leftPointer];
                nums[leftPointer]=nums[rightPointer];
                nums[rightPointer]=temp;
                leftPointer++;
                rightPointer--;
            }
        }
        return nums;
    }
}
