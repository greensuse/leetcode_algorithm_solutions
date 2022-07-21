package heap;

import java.util.PriorityQueue;

public class MinimumCostToConnect {
    public static void main(String[] args) {
        int[] sticks={3354,4316,3259,4904,4598,474,3166,6322,8080,9009};
        int ans=new MinimumCostToConnect().connectSticks(sticks);
        System.out.println(ans);
    }
    public int connectSticks(int[] sticks) {
        if(sticks.length==1) return 0;

        PriorityQueue<Integer> queue=new PriorityQueue<>(sticks.length);

        for(int val : sticks) {
            queue.offer(val);
        }

        int total_cost=0;
        while(queue.size()>1) {
            int s1_length=queue.poll();
            int s2_length=queue.poll();

            int last_sum=s1_length+s2_length;
            total_cost+=last_sum;
            queue.offer(last_sum);
        }
        return total_cost;
    }
}
