package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ShortestPathInBinaryMatrix_1 {
    private static final int[][] directions=new int[][]{{-1,-1}, {-1, 0}, {-1,1},{0,-1},{0,1},{1,1},{1,0},{1,-1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]!=0 || grid[grid.length-1][grid[0].length-1]!=0) return -1;

        Queue<int[]> queue=new ArrayDeque<>();
        queue.add(new int[]{0,0});
        grid[0][0]=1;

        while(!queue.isEmpty()) {
            int[] cell=queue.remove();
            int row=cell[0];
            int col=cell[1];
            int distance=grid[row][col];
            if(row==grid.length-1 && col==grid[0].length-1) return distance;

            List<int[]> neighbors = getNeighbors(row, col, grid);
            for(int[] neighbor : neighbors) {
                int neighborRow=neighbor[0];
                int neighborCol=neighbor[1];
                queue.add(new int[]{neighborRow, neighborCol});
                grid[neighborRow][neighborCol]=distance+1;
            }
        }
        return -1;
    }

    private List<int[]> getNeighbors(int row, int col, int[][] grid) {
        List<int[]> neighbors=new ArrayList<>();
        for(int[] dir : directions) {
            int newRow=row+dir[0];
            int newCol=col+dir[1];

            if(newRow<0 || newRow>=grid.length || newCol<0 || newCol>=grid[0].length)  continue;
            if(grid[newRow][newCol]!=0) continue;
            neighbors.add(new int[]{newRow, newCol});
        }
        return neighbors;
    }
}
