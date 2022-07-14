package binary_search;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left=0, right=arr.length-k;
        while(left<right) {
            int mid=left+(right-left)/2;
            if(x-arr[mid]>arr[mid+k]-x) {
                left=mid+1;
            } else {
                right=mid;
            }
        }

        List<Integer> result=new ArrayList<>(k);
        for(int i=0; i<k; i++) {
            result.add(arr[left+i]);
        }

        return result;
    }
}
