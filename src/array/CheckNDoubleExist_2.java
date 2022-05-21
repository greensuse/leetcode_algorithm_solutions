package array;

import java.util.HashSet;
import java.util.Set;

public class CheckNDoubleExist_2 {
    public static void main(String[] args) {
        int[] arr = {7,1,14,11};
        boolean result = checkIfExist(arr);
        System.out.println(result);

    }

    public static boolean checkIfExist(int[] arr) {
        Set<Integer> seenSet = new HashSet<>();

        for(int val : arr) {
            if(seenSet.contains(val*2) || (val%2==0 && seenSet.contains(val/2))) {
                return true;
            }
            seenSet.add(val);
        }

        return false;
    }
}
