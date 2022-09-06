package array;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->a[0]-b[0]);
        LinkedList<int[]> merged=new LinkedList<>();

        for(int[] arr : intervals) {
            if(merged.isEmpty() || arr[0]>merged.getLast()[1]) {
                merged.add(arr);
            } else {
                merged.getLast()[1]=Math.max(arr[1], merged.getLast()[1]);
            }
        }


        return merged.toArray(new int[merged.size()][]);

    }
}
