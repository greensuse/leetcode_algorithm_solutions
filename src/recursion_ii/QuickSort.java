package recursion_ii;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] array={15,3,2,1,9,5,7,8,6};
        int[] sorted=quickSort.sort(array);
        System.out.println(Arrays.toString(sorted));
    }

    public int[] sort(int[] array) {
        quickSort(array, 0, array.length-1);
        return array;
    }

    private void quickSort(int[] array, int left, int right) {
        if(left>=right) return;
        int pivot_value=array[(left+right)/2];
        int index=partition(array, left, right, pivot_value);
        quickSort(array, left, index-1);
        quickSort(array, index, right);
    }

    private int partition(int[] array, int left, int right, int pivot) {
        while(left<=right) {
            while(array[left]<pivot) {
                left++;
            }
            while(array[right]>pivot) {
                right--;
            }
            if(left<=right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }

        return left;
    }

    private void swap(int[] array, int left, int right) {
        int tmp=array[left];
        array[left]=array[right];
        array[right]=tmp;
    }
}
