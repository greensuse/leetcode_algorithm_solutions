package array_string;

import java.util.Arrays;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int length=nums.length;
        k=k%length;

        reverse(nums, 0, length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, length-1);
    }

    private void reverse(int[] nums, int left, int right) {
        while(left<right) {
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }

    }
}
