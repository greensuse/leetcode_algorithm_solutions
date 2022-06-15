package stack;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class FloodFill_3 {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor=image[sr][sc];
        if(originalColor==color) return image;

        int m=image.length, n=image[0].length;

        Queue<Pair> queue=new LinkedList<>();
        queue.offer(new Pair(sr, sc));

        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!queue.isEmpty()) {
            Pair p=queue.poll();
            image[p.x][p.y]=color;

            for(int[] dir : directions) {
                int x=p.x+dir[0];
                int y=p.y+dir[1];
                if (x >= 0 && x <= m-1 && y >= 0 && y <= n-1 && image[x][y] == originalColor ) {
                    queue.offer(new Pair(x,y));
                }

            }
        }

        return image;
    }

    private class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }
}
