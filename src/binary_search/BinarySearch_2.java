package binary_search;

public class BinarySearch_2 {
    public int search(int[] nums, int target) {
        int start=0, end=nums.length-1;
        int mid=0, mid_val=0;

        while(start<=end) {
            mid=start+(end-start)/2;
            if(target==nums[mid]) {
                return mid;
            } else if(target<nums[mid]) {
                end=mid-1;
            } else {
                start=mid+1;
            }
        }

        return -1;
    }
}
