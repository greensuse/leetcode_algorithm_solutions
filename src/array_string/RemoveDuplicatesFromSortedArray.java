package array_string;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int slow=1;
        for(int i=0; i<nums.length-1; i++) {
            if(nums[i]!=nums[i+1]) {
                nums[slow]=nums[i+1];
                slow++;
            }
        }
        return slow;
    }
}
