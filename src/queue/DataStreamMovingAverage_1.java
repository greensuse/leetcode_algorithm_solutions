package queue;

import java.util.LinkedList;
import java.util.Queue;

public class DataStreamMovingAverage_1 {
    private Queue queue = new LinkedList();

    private int capacity, length, sum;

    public DataStreamMovingAverage_1(int size) {
        this.capacity=size;
        this.length=0;
        this.sum=0;
    }

    public double next(int val) {
        if(length==capacity) {
            int popup=(int)queue.poll();
            sum-=popup;
            length--;
        }
        queue.offer(val);
        sum+=val;
        length++;
        return sum*1.0/length;
    }
}
