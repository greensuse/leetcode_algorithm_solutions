package two_pointer;

public class TrappingRainWater_1 {
    public int trap(int[] height) {
        int n=height.length;
        int[] left_high=new int[n];
        int[] right_high=new int[n];
        for(int i=0; i<n; i++) {
            if(i==0) {
                left_high[i]=height[i];
            } else {
                left_high[i]=Math.max(height[i], left_high[i-1]);
            }
        }
        for(int j=n-1; j>=0; j--) {
            if(j==n-1) {
                right_high[j]=height[j];
            } else {
                right_high[j]=Math.max(height[j], right_high[j+1]);
            }
        }

        int sum=0;
        for(int k=0; k<n; k++) {
            sum+=Math.min(left_high[k], right_high[k])-height[k];
        }

        return sum;
    }
}
