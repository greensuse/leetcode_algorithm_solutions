package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

//top-down implementation
public class ClimbStairs_1 {
    private Map<Integer, Integer> memo=new HashMap<Integer, Integer>();
    private int dp(int i) {
        if(i<=2) return i;
        if(!memo.containsKey(i)) {
            memo.put(i, dp(i-1)+dp(i-2));
        }
        return memo.get(i);
    }

    public int climbStairs(int n) {
        return dp(n);
    }
}
