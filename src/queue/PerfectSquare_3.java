package queue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class PerfectSquare_3 {
    public static void main(String[] args) {
        int res = numSquares(12);
        System.out.println(res);
    }

    public static int numSquares(int n) {
        int maxSquareRoot = (int)Math.sqrt(n);

        int[] squares=new int[maxSquareRoot];
        for(int i=1; i<=maxSquareRoot; i++) {
            squares[i-1]=i*i;
        }

        Queue<Integer> queue=new LinkedList<>();
        queue.offer(n);

        int steps = 0;
        int[] visited=new int[n];
        visited[n-1]=1;

        while(!queue.isEmpty()) {
            steps++;
            int size = queue.size();
            for(int j=0; j<size; j++) {
                int num = queue.poll();
                for (int i = 1; i <= maxSquareRoot; i++) {
                    int remainder = num - i * i;

                    if (remainder < 0) break;

                    if (remainder == 0) {
                        return steps;
                    } else if (visited[remainder-1]==0) {
                        queue.offer(remainder);
                        visited[remainder-1]=1;
                    }
                }
            }
        }

        return 0;
    }
}
