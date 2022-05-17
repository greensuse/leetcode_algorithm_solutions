package array;

import java.util.Arrays;

public class Duplicate_zeros1089_1 {
    public static void main(String[] args) {
        int[] arr= {1,0,2,3,0,4,5,0};
        duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void duplicateZeros(int[] arr) {
        int len=arr.length;
        int[] temp=new int[len];
        int size=0;
        for(int i=0; i<=len-1; i++) {
            if(size>=len) {
                break;
            }
            if(arr[i]!=0) {
                temp[size++]=arr[i];
            } else {
                temp[size++]=0;
                if(size<len) {
                    temp[size++] = 0;
                }
            }
        }
        for(int i=0; i<len; i++) {
            arr[i]  = temp[i];
        }
    }
}
