package stack;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class FloodFill_2 {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor=image[sr][sc];
        if(originalColor==color) return image;

        Set<String> visited=new HashSet<>();

        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        visited.add(sr+","+sc);

        while(!queue.isEmpty()) {
            int[] p=queue.poll();
            image[p[0]][p[1]]=color;

            if(p[0]-1>=0 && image[p[0]-1][p[1]]==originalColor && !visited.contains((p[0]-1) +","+p[1])) {
                queue.offer(new int[]{p[0]-1, p[1]});
                visited.add((p[0]-1) +","+p[1]);
            }
            if(p[0]+1<=image.length-1 && image[p[0]+1][p[1]]==originalColor && !visited.contains((p[0]+1) +","+p[1])) {
                queue.offer(new int[]{p[0]+1, p[1]});
                visited.add((p[0]+1) +","+p[1]);

            }
            if(p[1]-1>=0 && image[p[0]][p[1]-1]==originalColor && !visited.contains(p[0] +","+(p[1]-1))) {
                queue.offer(new int[]{p[0], p[1]-1});
                visited.add(p[0] +","+(p[1]-1));
            }
            if(p[1]+1<=image[0].length-1 && image[p[0]][p[1]+1]==originalColor && !visited.contains(p[0] +","+(p[1]+1))) {
                queue.offer(new int[]{p[0], p[1]+1});
                visited.add(p[0] +","+(p[1]+1));
            }

        }

        return image;
    }
}
