package queue;

import java.util.LinkedList;
import java.util.Queue;

public class DataStreamMovingAverage_4 {
    private int[] queue;

    private int size, count=0, sum=0, head=0;

    public DataStreamMovingAverage_4(int size) {
        this.size=size;
        queue=new int[size];
    }

    public double next(int val) {
        count++;

        int tail=(head+1)%size;

        sum+=sum-queue[tail]+val;
        //move on to the new head
        head=(head+1)%size;
        queue[head]=val;

        return sum*1.0/Math.min(size, count);
    }
}
