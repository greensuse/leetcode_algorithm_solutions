package array;

import java.util.Arrays;

public class ReplaceElementsWithGreatestOnRight_2 {

    public static void main(String[] args) {
        int[] arr = {17,18,5,4,6,1};
        int[] result = replaceElements(arr);
        System.out.println(Arrays.toString(result));
    }

    public static int[] replaceElements(int[] arr) {
        if(arr.length==1) {
            arr[0]=-1;
            return arr;
        }

        int last_value=arr[arr.length-1], max=-1;
        arr[arr.length-1]=-1;

        for(int i=arr.length-2; i>=0; i--) {
            max=Math.max(last_value, max);
            last_value=arr[i];
            arr[i] = max;
        }
        return arr;
    }
}
