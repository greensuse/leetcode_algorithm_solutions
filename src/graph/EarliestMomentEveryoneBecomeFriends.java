package graph;

import java.util.Arrays;

public class EarliestMomentEveryoneBecomeFriends {
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (int[] a1, int[] a2)-> a1[0]-a2[0]);

        UnionFind3 unionFind=new UnionFind3(n);

        for(int[] log: logs) {
            unionFind.union(log[1], log[2]);
            if(unionFind.getCount()==1) {
                return log[0];
            }
        }

        return -1;
    }
}
