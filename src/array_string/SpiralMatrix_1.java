package array_string;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_1 {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1,2,3},{4,5,6},{7,8,9}
        };
        List<Integer> res = spiralOrder(matrix);
        System.out.println(res);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        String direction="right";
        int m=matrix.length, n=matrix[0].length;
        int topRow=0, bottomRow=m-1, leftCol=0, rightCol=n-1;

        int row=0, col=0, index=0;
        List<Integer> res=new ArrayList<>(m*n);

        while(row>=0 && row<m && col>=0 && col<n) {
            if(direction.equals("right")) {
                while(col<rightCol) {
                    res.add(matrix[row][col]);
                    col++;
                }
                if(col>rightCol) break;

                if(col==rightCol && row==bottomRow) {
                    res.add(matrix[row][col]);
                    break;
                }
                direction="down";
                topRow++;
            } else if(direction.equals("down")) {
                while(row<bottomRow) {
                    res.add(matrix[row][col]);
                    row++;
                }
                if(row==bottomRow && col==leftCol) {
                    res.add(matrix[row][col]);
                    break;
                }
                if(row>bottomRow) break;
                direction="left";
                rightCol--;
            } else if(direction.equals("left")) {
                while(col>leftCol) {
                    res.add(matrix[row][col]);
                    col--;
                }
                if(col<leftCol) break;
                if(col==leftCol && row==topRow) {
                    res.add(matrix[row][col]);
                    break;
                }
                direction="up";
                bottomRow--;
            } else if(direction.equals("up")) {
                while(row>topRow) {
                    res.add(matrix[row][col]);
                    row--;
                }
                if(row<topRow) break;
                if(row==topRow && col==rightCol) {
                    res.add(matrix[row][col]);
                    break;
                }
                direction="right";
                leftCol++;
            }
        }

        return res;
    }
}
