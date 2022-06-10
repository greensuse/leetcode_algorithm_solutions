package queue;

import java.util.LinkedList;
import java.util.Queue;

public class PerfectSquare_1 {
    public static void main(String[] args) {
        int res = numSquares(13);
        System.out.println(res);
    }

    public static int numSquares(int n) {
        int sqrRoot = (int)Math.sqrt(n), level = 0;
        boolean[] visited = new boolean[n];
        int[] perfectSquare = new int[sqrRoot];

        for(int i = 1; i <= sqrRoot; ++i) perfectSquare[i - 1] = i * i;

        Queue<Integer> q = new LinkedList();
        q.offer(n);

        while(!q.isEmpty()){
            level++;
            int size = q.size();
            for(int i = 0; i < size; ++i){
                int num = q.poll();

                for(int pSquare : perfectSquare){
                    int remain = num - pSquare;
                    if(remain == 0){
                        return level;
                    }else if(remain > 0 && !visited[remain - 1]){
                        visited[remain - 1] = true;
                        q.offer(remain);
                    }else if(remain < 0){
                        break;
                    }
                }
            }
        }

        return 0;
    }
}
