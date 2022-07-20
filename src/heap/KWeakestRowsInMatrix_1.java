package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KWeakestRowsInMatrix_1 {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<SoldierRow> queue=new PriorityQueue<>();
        for(int i=0; i<mat.length; i++) {
            queue.add(new SoldierRow(getTotalOnes(mat[i]), i));
        }

        int[] ans=new int[k];
        for(int j=0; j<k; j++) {
            ans[j]=queue.poll().rowIndex;
        }

        return ans;
    }

    private int getTotalOnes(int[] row) {
        return Arrays.stream(row).sum();
    }


    class SoldierRow implements Comparable<SoldierRow>{
        int soldierNum;
        int rowIndex;

        public SoldierRow(int soldierNum, int rowIndex) {
            this.soldierNum=soldierNum;
            this.rowIndex=rowIndex;
        }

        public int compareTo(SoldierRow s2) {
            if(this.soldierNum<s2.soldierNum) return -1;
            else if(this.soldierNum==s2.soldierNum && this.rowIndex<s2.rowIndex) return -1;

            return 1;
        }
    }
}
