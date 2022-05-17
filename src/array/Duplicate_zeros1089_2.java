package array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Duplicate_zeros1089_2 {
    public static void main(String[] args) {
        int[] arr= {1,0,2,3,0,4,5,0};
        duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void duplicateZeros(int[] arr) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<arr.length; i++) {
            if(arr[i]==0) {
                queue.add(0);
                queue.add(0);
            } else {
                queue.add(arr[i]);
            }
            arr[i]=queue.poll();
        }
    }
}
