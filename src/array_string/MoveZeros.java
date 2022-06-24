package array_string;

public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int slow=0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]!=0) {
                nums[slow]=nums[i];
                slow++;
            }
        }
        for(int j=slow; j<nums.length; j++) {
            nums[j]=0;
        }
    }
}
