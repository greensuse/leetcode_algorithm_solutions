package array;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left=0, right=height.length-1, max_area=0;

        while(left<right) {
            max_area=Math.max(max_area, Math.min(height[left], height[right]) * (right-left));
            if(height[left]<=height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max_area;
    }
}
