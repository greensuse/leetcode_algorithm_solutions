package dp;

import java.util.HashMap;
import java.util.Map;

public class MinCostClimbingStairs_1 {
    int[] cost;
    Map<Integer, Integer> memo=new HashMap<>();
    public int minCostClimbingStairs(int[] cost) {
        this.cost=cost;
        return dp(cost.length);
    }
    private int dp(int i) {
        if(i<=1) return 0;

        if(!memo.containsKey(i)) {
            int downOne=dp(i-1)+cost[i-1];
            int downTwo=dp(i-2)+cost[i-2];
            memo.put(i, Math.min(downOne, downTwo));
        }
        return memo.get(i);
    }
}
