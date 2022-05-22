package array;

import java.util.Arrays;

//leetcode 1051
public class HeightChecker {
    public static void main(String[] args) {
        int[] heights = {1,1,4,2,1,3};
        int result=heightChecker(heights);
        System.out.println(result);
    }

    public static int heightChecker(int[] heights) {
        int[] oldArray = heights.clone();
        Arrays.sort(heights);

        int notMatch=0;
        for(int i=0; i<heights.length; i++) {
            if(oldArray[i]!=heights[i]) notMatch++;
        }

        return notMatch;
    }
}
