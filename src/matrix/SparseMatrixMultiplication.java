package matrix;

public class SparseMatrixMultiplication {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int rowA=mat1.length;
        int colA=mat1[0].length;
        int colB=mat2[0].length;
        int[][] res=new int[rowA][colB];
        for(int i=0; i<rowA; i++) {
            for(int j=0; j<colA; j++) {
                if(mat1[i][j]!=0) {
                    for(int k=0; k<colB; k++) {
                        if(mat2[j][k]!=0) {
                            res[i][k]+=mat1[i][j]*mat2[j][k];
                        }
                    }
                }
            }
        }
        return res;
    }
}
