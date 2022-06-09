package queue;

import java.util.LinkedList;
import java.util.Queue;

public class WallAndGates {
    public static void main(String[] args) {
        int[][] rooms = {
                {2147483647,-1,0,2147483647},
                {2147483647,2147483647,2147483647,-1},
                {2147483647,-1,2147483647,-1},
                {0,-1,2147483647,2147483647}
        };

        wallsAndGates(rooms);
    }
    public static void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue=new LinkedList<>();
        for(int i=0; i<rooms.length; i++) {
            for(int j=0; j<rooms[0].length; j++) {
                if(rooms[i][j]==0) {
                    queue.offer(new int[]{i,j});
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] top=queue.poll();
            int row=top[0], col=top[1];

            if(row>0 && rooms[row-1][col]==Integer.MAX_VALUE) {
                rooms[row-1][col]=rooms[row][col]+1;
                queue.offer(new int[]{row-1, col});
            }

            if( row<rooms.length-1 && rooms[row+1][col]==Integer.MAX_VALUE) {
                rooms[row+1][col]=rooms[row][col]+1;
                queue.offer(new int[]{row+1, col});
            }

            if(col>0 && rooms[row][col-1]==Integer.MAX_VALUE) {
                rooms[row][col-1]=rooms[row][col]+1;
                queue.offer(new int[]{row, col-1});
            }

            if(col<rooms[0].length-1 && rooms[row][col+1]==Integer.MAX_VALUE) {
                rooms[row][col+1]=rooms[row][col]+1;
                queue.offer(new int[]{row, col+1});
            }
        }
    }
}
