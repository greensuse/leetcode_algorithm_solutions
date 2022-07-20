package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KWeakestRowsInMatrix_2 {
    public static void main(String[] args) {
        int[][] mat={{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}};
        int[] ans=new KWeakestRowsInMatrix_2().kWeakestRows(mat, 3);
        System.out.println(Arrays.toString(ans));
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> queue=new PriorityQueue<>((a,b)->{
            if(a[0]==b[0]) return b[1]-a[1];
            else return b[0]-a[0];
        });
        for(int i=0; i<mat.length; i++) {
            queue.add(new int[]{getTotalOnes(mat[i]), i});
            if(queue.size()>k) {
                int[] removed = queue.poll();
                System.out.println("removed: " + Arrays.toString(removed));
            }
        }

        int[] ans=new int[k];
        for(int j=k-1; j>=0; j--) {
            ans[j]=queue.poll()[1];
        }

        return ans;
    }

    private int getTotalOnes(int[] row) {
        int L=0, R=row.length;

        while(L<R) {
            int mid=L+(R-L)/2;
            if(row[mid]==0) {
                R=mid;
            } else {
                L=mid+1;
            }
        }

        return L;
    }
}
