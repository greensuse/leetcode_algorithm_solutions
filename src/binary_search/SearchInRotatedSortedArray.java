package binary_search;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        //find pivot
        int left=0, right=nums.length-1;

        while(left<right) {
            int mid=left+(right-left)/2;
            if(nums[mid]>nums[right]) {
                left=mid+1;
            } else {
                right=mid;
            }
        }

        int start=left;
        left=0;
        right=nums.length-1;

        if(target>=nums[start] && target<=nums[right]) {
            left=start;
        } else {
            right=start;
        }

        while(left<=right) {
            int mid=left+(right-left)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]>target) right=mid-1;
            else left=mid+1;
        }

        return -1;
    }
}
