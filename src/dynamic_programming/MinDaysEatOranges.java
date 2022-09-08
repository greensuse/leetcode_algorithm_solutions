package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class MinDaysEatOranges {
    public static void main(String[] args) {
        int res=new MinDaysEatOranges().minDays(56);
        System.out.println(res);
    }
    Map<Integer, Integer> memo=new HashMap<>();
    public int minDays(int n) {
        if(n<=2) return n;
        if(n==3) return 2;

        if(memo.containsKey(n)) return memo.get(n);

        int value = Math.min(n%3+1+minDays(n/3), n%2+1+minDays(n/2));
        memo.put(n, value);
        System.out.println("n="+n+", days="+value);
        return value;
    }
}
