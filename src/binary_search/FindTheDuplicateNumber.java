package binary_search;

public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            int index=Math.abs(nums[i])-1;

            if(nums[index]<0) {
                return index+1;
            } else {
                nums[index]=-nums[index];
            }
        }

        return -1;
    }
}
