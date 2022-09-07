package two_pointer;

public class TrappingRainWater_2 {
    public int trap(int[] height) {
        int n=height.length;
        int[] left_high=new int[n];
        int[] right_high=new int[n];

        int max_index=0;
        for(int i=1; i<n; i++) {
            if(height[i]>height[max_index]) {
                max_index=i;
            }
        }

        int sum=0;
        int left_max=height[0];
        for(int i=1; i<max_index; i++) {
            left_max=Math.max(height[i], left_max);
            sum+=left_max-height[i];

        }
        int right_max=height[n-1];
        for(int j=n-2; j>max_index; j--) {
            right_max=Math.max(height[j], right_max);
            sum+=right_max-height[j];
        }

        return sum;
    }
}
