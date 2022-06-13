package stack;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues_2 {
    Queue<Integer> queue=new LinkedList<>();

    public ImplementStackUsingQueues_2() {

    }

    public void push(int x) {
        queue.offer(x);
    }

    public int pop() {
        for(int i=0; i<queue.size()-1; i++) {
            queue.offer(queue.poll());
        }

        return queue.poll();
    }

    public int top() {
        for(int i=0; i<queue.size()-1; i++) {
            queue.offer(queue.poll());
        }
        int res=queue.peek();
        queue.offer(queue.poll());

        return res;
    }

    public boolean empty() {
        return queue.size()==0;
    }
}
