package array_string;

public class LargestNumberTwiceOfOthers {
    public int dominantIndex(int[] nums) {
        if(nums.length==1) return 0;

        int largestIndex=-1;

        int secondLargest=0, largest=0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]>largest) {
                secondLargest=largest;
                largest=nums[i];
                largestIndex=i;
            } else if(nums[i]>secondLargest) {
                secondLargest=nums[i];
            }
        }

        if(secondLargest==0 && largest!=0) return largestIndex;

        return largest/secondLargest>=2?largestIndex:-1;
    }
}
