package array_string;

public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] mat) {
        int m=mat.length, n=mat[0].length;
        int[] res=new int[m*n];
        boolean up=true;
        int row=0, col=0, index=0;

        while(row<m && col<n) {
            if(up) {
                while(row>0 && col<n-1) {
                    res[index++] = mat[row][col];
                    row--;
                    col++;
                }
                res[index++] = mat[row][col];
                if(col==n-1) {
                    row++;
                } else {
                    col++;
                }

            } else {
                while(col>0 && row<m-1) {
                    res[index++] = mat[row][col];
                    row++;
                    col--;
                }
                res[index++] = mat[row][col];
                if(row==m-1) {
                    col++;
                } else {
                    row++;
                }
            }
            up=!up;
        }

        return res;
    }
}
