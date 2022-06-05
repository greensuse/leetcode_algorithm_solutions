package queue;

import java.util.LinkedList;
import java.util.Queue;

public class DataStreamMovingAverage_3 {
    private Queue<Integer> queue = new LinkedList<>();

    private int capacity, length, sum;

    public DataStreamMovingAverage_3(int size) {
        this.capacity=size;
    }

    public double next(int val) {
        length++;
        queue.offer(val);

        int tail=length>capacity?queue.poll():0;

        sum=sum+val-tail;

        return sum*1.0/Math.min(capacity, length);
    }
}
