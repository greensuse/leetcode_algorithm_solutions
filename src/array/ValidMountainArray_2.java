package array;

public class ValidMountainArray_2 {

    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,7,8,9};
        boolean result = validMountainArray(arr);
        System.out.println(result);
    }

    public static boolean validMountainArray(int[] arr) {
        if(arr.length<3) return false;

        int i=0;
        while(i<arr.length-1 && arr[i]<arr[i+1]) {
            i++;
        }

        if(i==0 && i==arr.length-1) return false;

        while(i<arr.length-1 && arr[i+1]<arr[i]){
            i++;
        }

        return i==arr.length-1;

    }
}
