package array_string;

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i=0, j=0, max_len=0;

        while(j<nums.length) {
            while(i<nums.length && nums[i]!=1) {
                i++;
            }
            j=i;
            while(j<nums.length && nums[j]!=0) {
                j++;
            }

            max_len=(j-i)>max_len?(j-i):max_len;
            i=j;
        }

        return max_len;

    }
}
