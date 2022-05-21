package array;

import java.util.HashMap;
import java.util.Map;

public class CheckNDoubleExist_1 {
    public static void main(String[] args) {
        int[] arr = {7,1,14,11};
        boolean result = checkIfExist(arr);
        System.out.println(result);

    }

    public static boolean checkIfExist(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int val : arr) {
            map.put(val, map.get(val)==null?1:map.get(val)+1);
        }

        for(int val : arr) {
            if(val==0) {
                if (map.get(0)>1) {
                    return true;
                } else {
                    continue;
                }
            }

            if(val%2==0)  {
                if(map.containsKey(val/2)) {
                    return true;
                }
            }

            if(map.containsKey(val*2)) {
                return true;
            }
        }

        return false;
    }
}
