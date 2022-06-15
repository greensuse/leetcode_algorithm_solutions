package queue;

import java.awt.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Matrix01 {
    public static void main(String[] args) {
        int[][] mat={{0,0,0},{0,1,0},{1,1,1}};
        int[][] res=updateMatrix(mat);
        System.out.println(res);
    }
    public static int[][] updateMatrix(int[][] matrix) {
        int m=matrix.length, n=matrix[0].length;
        Queue<int[]> queue=new LinkedList<>();

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(matrix[i][j]==0) {
                    queue.add(new int[]{i,j});
                } else {
                    matrix[i][j]=-1;
                }
            }
        }

        int[][] dirs={{-1,0},{1,0},{0,-1},{0,1}};
        int steps = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            steps++;
            while(size-->0) {
                int[] cell = queue.poll();
                for(int[] dir : dirs) {
                    int r = cell[0]+dir[0];
                    int c = cell[1]+dir[1];
                    if(r<0 || c<0 || r==m || c==n || matrix[r][c]!=-1) continue;
                    matrix[r][c]=steps;
                    queue.add(new int[]{r,c});
                }
            }
        }

        return matrix;
    }

}
