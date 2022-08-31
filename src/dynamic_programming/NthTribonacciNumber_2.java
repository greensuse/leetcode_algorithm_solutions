package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class NthTribonacciNumber_2 {
    Map<Integer, Integer> memo=new HashMap<>();

    public int tribonacci(int n) {
        if(n==0) return 0;
        if(n<3) return 1;

        if(!memo.containsKey(n)) {
            memo.put(n, tribonacci(n-3)+tribonacci(n-2)+tribonacci(n-1));
        }
        return memo.get(n);
    }
}
