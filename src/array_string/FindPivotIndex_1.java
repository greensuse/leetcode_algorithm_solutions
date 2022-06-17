package array_string;

public class FindPivotIndex_1 {
    public int pivotIndex(int[] nums) {
        int sum=0;
        for(int num : nums) sum+=num;
        int left=0, right=sum;

        for(int i=0; i<nums.length; i++) {
            if(i-1>=0) left+=nums[i-1];
            right-=nums[i];

            if(left==right) {return i;} else {continue;}
        }
        return -1;
    }
}
