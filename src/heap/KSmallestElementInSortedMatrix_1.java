package heap;

public class KSmallestElementInSortedMatrix_1 {
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length-1;
        int L=matrix[0][0], R=matrix[n][n];

        while(L<R) {
            int mid=L+(R-L)/2;
            int count=countLessOrEqual(matrix, mid);
            if(count<k) {
                L=mid+1;
            } else {
                R=mid;
            }
        }

        return L;
    }

    private int countLessOrEqual(int[][] matrix, int mid) {
        int row=0, col=matrix.length-1, count=0;
        while(row<matrix.length && col>=0) {
            if(matrix[row][col]<=mid) {
                count+=col+1;
                row++;
            } else {
                col--;
            }
        }
        return count;
    }
}
