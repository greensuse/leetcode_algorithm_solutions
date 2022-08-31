package dynamic_programming;

public class MinCostClimbingStairs_2 {

    public int minCostClimbingStairs(int[] cost) {
        int downOne=0, downTwo=0;
        for(int i=2; i<=cost.length; i++) {
            int tmp=downOne;
            downOne=Math.min(downOne+cost[i-1], downTwo+cost[i-2]);
            downTwo=tmp;
        }
        return downOne;
    }

}
