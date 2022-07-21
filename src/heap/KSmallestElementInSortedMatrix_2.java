package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KSmallestElementInSortedMatrix_2 {
    public static void main(String[] args) {
        int[][] matrix={{1,3,5},{6,7,12},{11,14,14}};
        int ans=new KSmallestElementInSortedMatrix_2().kthSmallest(matrix, 3);
        System.out.println(ans);
    }

    class MyHeapNode {
        int val,col,row;

        public MyHeapNode(int val, int row, int col) {
            this.val=val;
            this.col=col;
            this.row=row;
        }
    }

    class MyHeapComparator implements Comparator<MyHeapNode> {
        public int compare(MyHeapNode n1, MyHeapNode n2) {
            return n1.val-n2.val;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        int n=Math.min(matrix.length, k);
        PriorityQueue<MyHeapNode> queue=new PriorityQueue<>(n, new MyHeapComparator());

        for(int i=0; i<n; i++) {
            queue.offer(new MyHeapNode(matrix[i][0], i, 0));
        }

        MyHeapNode element=queue.peek();
        while(k-->0) {
            element=queue.poll();
            int row=element.row;
            int col=element.col+1;
            if(col<matrix.length) {
                queue.offer(new MyHeapNode(matrix[row][col], row, col));
            }
        }
        return element.val;
    }
}
