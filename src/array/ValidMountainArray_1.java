package array;

public class ValidMountainArray_1 {

    public static void main(String[] args) {
        int[] arr = {0,3,2,1};
        boolean result = validMountainArray(arr);
        System.out.println(result);
    }

    public static boolean validMountainArray(int[] arr) {
        int flip_index=0;
        for(int i=1; i<arr.length-1; i++) {
            if(arr[i]<=arr[i-1]) {
                return false;
            } else if(arr[i]>arr[i-1] && arr[i]>arr[i+1]) {
                flip_index=i;
                break;
            }
        }

        for(int i=flip_index+1; i<=arr.length-1; i++) {
            if(arr[i]>=arr[i-1]) {
                return false;
            }
        }

        if (flip_index>0) {return true;}

        return false;

    }
}
