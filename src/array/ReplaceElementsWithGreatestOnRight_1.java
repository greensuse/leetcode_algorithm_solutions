package array;

import java.util.Arrays;

public class ReplaceElementsWithGreatestOnRight_1 {

    public static void main(String[] args) {
        int[] arr = {17,18,5,4,6,1};
        int[] result = replaceElements(arr);
        System.out.println(Arrays.toString(result));
    }

    public static int[] replaceElements(int[] arr) {
        int max_value=0, max_index=-1;
        for(int i=0; i<arr.length; i++) {
            if(i==arr.length-1) {
                arr[i]=-1;
            } else if(max_index>i) {
                arr[i]=max_value;
            } else {
                max_index=i+1;
                max_value=arr[i+1];
                for(int j=i+2; j<arr.length; j++) {
                    if(arr[j]>max_value) {
                        max_index=j;
                        max_value=arr[j];
                    }
                }
                arr[i]=max_value;
            }
        }
        return arr;
    }
}
