package array_string;

public class FindPivotIndex_2 {
    public int pivotIndex(int[] nums) {
        int sum=0;
        for(int num : nums) sum+=num;
        int left=0, right=sum;

        for(int i=0; i<nums.length; i++) {
            right-=nums[i];
            if(left==right) {return i;}
            left+=nums[i];
        }
        return -1;
    }
}
