package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class TwoCityScheduling {
    public static void main(String[] args) {
        int[][] costs={{10,20},{30,200},{400,50},{30,20}};
        int res=new TwoCityScheduling().twoCitySchedCost(costs);
        System.out.println(res);
    }
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]> () {
            public int compare(int[] ar1, int[] ar2) {
                return (ar1[0]-ar1[1]) - (ar2[0]-ar2[1]);
            }
        });

        int n=costs.length/2;
        int res=0;
        for(int i=0; i<n; i++) {
            res+=costs[i][0]+costs[i+n][1];
        }
        return res;
    }
}
