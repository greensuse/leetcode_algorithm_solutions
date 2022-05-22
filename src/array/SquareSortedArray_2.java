package array;

import java.util.Arrays;

public class SquareSortedArray_2 {
    public static void main(String[] args) {
        int[] nums = {-7,-3,2,3,11};
        int[] result = sortedSquares(nums);
        System.out.println(Arrays.toString(result));
    }
    public static int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int left=0, right=nums.length-1;

        int index=nums.length-1;
        while(left<=right) {
            if(Math.abs(nums[left])>Math.abs(nums[right])) {
                result[index--]=nums[left]*nums[left];
                left++;
            } else {
                result[index--]=nums[right]*nums[right];
                right--;
            }
        }
        return result;
    }
}
