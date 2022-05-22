package array;

import java.util.Arrays;

public class SquareSortedArray_1 {
    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        int[] result = sortedSquares(nums);
        System.out.println(Arrays.toString(result));
    }
    public static int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int left=0, right=nums.length-1;

        for(int i=nums.length-1; i>=0; i--) {
            if(nums[left]*nums[left]>nums[right]*nums[right]) {
                result[i]=nums[left]*nums[left];
                left++;
            } else {
                result[i]=nums[right]*nums[right];
                right--;
            }
        }
        return result;
    }
}
