package array_string;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_3 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m=matrix.length, n=matrix[0].length;
        int rowBegin=0, rowEnd=m-1, colBegin=0, colEnd=n-1;

        List<Integer> res=new ArrayList<>(m*n);

        while(rowBegin<=rowEnd && colBegin<=colEnd) {
            //right
            for(int i=colBegin; i<=colEnd; i++) {
                res.add(matrix[rowBegin][i]);
            }
            rowBegin++;

            //down
            for(int i=rowBegin; i<=rowEnd; i++) {
                res.add(matrix[i][colEnd]);
            }
            colEnd--;

            //left
            if(rowEnd>=rowBegin) {
                for(int i=colEnd; i>=colBegin; i--) {
                    res.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;

            //up
            if(colBegin<=colEnd) {
                for(int i=rowEnd; i>=rowBegin; i--) {
                    res.add(matrix[i][colBegin]);
                }
            }
            colBegin++;
        }

        return res;
    }
}
