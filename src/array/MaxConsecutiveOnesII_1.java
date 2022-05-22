package array;

public class MaxConsecutiveOnesII_1 {
    public static void main(String[] args) {
        int[] nums= {1,0,1,1,0,1,1};
        int result = findMaxConsecutiveOnes(nums);
        System.out.println(result);
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        if(nums.length==1) return 1;

        int maxLength=0;
        for(int i=0; i<nums.length-1; i++) {
            int zeros=0;
            for(int j=i; j<nums.length;j++) {
                if(nums[j]==0) zeros++;
                if(zeros>1) break;

                if((j-i+1)>maxLength) {
                    maxLength=j-i+1;
                }
            }
        }

        return maxLength;
    }
}
