package queue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class PerfectSquare_2 {
    public static void main(String[] args) {
        int res = numSquares(25);
        System.out.println(res);
    }

    public static int numSquares(int n) {
        int maxSquareRoot = (int)Math.sqrt(n);

        Queue<Integer> queue=new LinkedList<>();
        queue.offer(n);

        int steps = 0;
        Set<Integer> visited=new HashSet<>();
        visited.add(n);

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
                    } else if (!visited.contains(remainder)) {
                        queue.offer(remainder);
                        visited.add(remainder);
                    }
                }
            }
        }

        return 0;
    }
}
