package recursion_ii;

public class Search2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0) return false;
        int row=matrix.length, col=matrix[0].length;
        if(target<matrix[0][0] || target>matrix[row-1][col-1]) return false;

        int row_index=row-1, col_index=0;
        while(row_index>=0 && col_index<col) {
            if(target<matrix[row_index][col_index]) {
                row_index--;
            } else if(target>matrix[row_index][col_index]) {
                col_index++;
            } else{
                return true;
            }
        }
        return false;
    }
}
