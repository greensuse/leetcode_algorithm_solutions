package recursion_i;

import java.util.HashMap;
import java.util.Map;

public class FibonacciNumber_2 {
    private static Map<Integer, Integer> map=new HashMap<>();
    public static int fib(int n) {
        if(map.containsKey(n)) return map.get(n);

        int result;
        if(n<2) {
            result =  n;
        } else {
            result = fib(n-1)+fib(n-2);
        }

        //keep the result in cache
        map.put(n, result);
        return result;
    }
}
