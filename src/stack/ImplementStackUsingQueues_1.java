package stack;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues_1 {
    Queue<Integer> q1=new LinkedList<>();
    Queue<Integer> q2=new LinkedList<>();

    public ImplementStackUsingQueues_1() {

    }

    public void push(int x) {
        q1.offer(x);
    }

    public int pop() {
        if(q1.size()==0 && q2.size()>0) {
            while(q2.size()>0) {
                q1.offer(q2.poll());
            }
        }

        while(q1.size()>1) {
            q2.offer(q1.poll());
        }

        return q1.poll();
    }

    public int top() {
        if(q1.size()==0 && q2.size()>0) {
            while(q2.size()>0) {
                q1.offer(q2.poll());
            }
        }

        while(q1.size()>1) {
            q2.offer(q1.poll());
        }

        return q1.peek();
    }

    public boolean empty() {
        return q1.size()==0 && q2.size()==0;
    }
}
