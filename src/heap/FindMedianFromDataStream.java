package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {

    private PriorityQueue<Integer> max_queue=new PriorityQueue(Collections.reverseOrder());
    private PriorityQueue<Integer> min_queue=new PriorityQueue();


    public FindMedianFromDataStream() {
    }

    public void addNum(int num) {
        max_queue.add(num);

        if(max_queue.size()-min_queue.size()>1) {
            min_queue.add(max_queue.poll());
        }

        if(min_queue.size()>0 && max_queue.peek()>min_queue.peek()) {
            int a=max_queue.poll();
            max_queue.offer(min_queue.poll());
            min_queue.offer(a);
        }
    }

    public double findMedian() {
        if(max_queue.size()>min_queue.size()) return max_queue.peek();
        else return (max_queue.peek()+min_queue.peek())/2.0;
    }
}
