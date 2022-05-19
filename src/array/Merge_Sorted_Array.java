package array;

import java.util.Arrays;

public class Merge_Sorted_Array {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3, n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m+n];
        int nums1_index=0, nums2_index=0;
        for(int i=0; i<m+n; i++) {
            if(nums2_index>=n || (nums1_index<m && nums1[nums1_index]<=nums2[nums2_index])) {
                temp[i]=nums1[nums1_index];
                nums1_index++;
            } else if(nums2_index<n) {
                temp[i]=nums2[nums2_index];
                nums2_index++;
            }
        }

        for(int i=0; i<m+n; i++) {
            nums1[i]=temp[i];
        }

    }
}
