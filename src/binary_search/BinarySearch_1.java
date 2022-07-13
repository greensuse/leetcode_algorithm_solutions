package binary_search;

public class BinarySearch_1 {
    public int search(int[] nums, int target) {
        return doSearch(nums, 0, nums.length-1, target);
    }

    private int doSearch(int[] nums, int start, int end, int target) {
        if(start>end) return -1;
        int mid=start+(end-start)/2;
        int mid_value=nums[mid];

        if(mid_value==target) return mid;

        if(target<mid_value) {
            return doSearch(nums, start, mid-1, target);
        } else {
            return doSearch(nums, mid+1, end, target);
        }

    }
}
