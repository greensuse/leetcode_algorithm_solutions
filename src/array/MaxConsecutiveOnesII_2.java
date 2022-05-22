package array;

public class MaxConsecutiveOnesII_2 {
    public static void main(String[] args) {
        int[] nums= {1,0,1,1,0,1,1};
        int result = findMaxConsecutiveOnes(nums);
        System.out.println(result);
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        if(nums.length==1) return 1;

        int longestSequence=0;
        int numZeroes=0;
        int left=0, right=0;
        while(right<nums.length) {

            // add the right most element into our window
            if(nums[right]==0) {
                numZeroes++;
            }

            // if our window is invalid, contract our window
            while(numZeroes==2) {
                if(nums[left]==0) {
                    numZeroes--;
                }
                left++;
            }


            longestSequence=Math.max(longestSequence, right-left+1);

            // expand our window
            right++;
        }

        return longestSequence;
    }
}
