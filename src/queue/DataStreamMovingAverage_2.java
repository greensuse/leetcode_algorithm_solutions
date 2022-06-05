package queue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DataStreamMovingAverage_2 {

    public static void main(String[] args) {
        DataStreamMovingAverage_2 main = new DataStreamMovingAverage_2(3);
        double ave = main.next(1);
        ave = main.next(1);
        ave = main.next(10);
        ave = main.next(3);
        ave = main.next(5);

    }
    private List<Integer> queue = new LinkedList<>();

    private int windowSize;

    public DataStreamMovingAverage_2(int size) {
        this.windowSize=size;
    }

    public double next(int val) {
        queue.add(val);

        int sum=0;
        for(int i=Math.max(0, queue.size()-windowSize); i<queue.size(); i++) {
            sum+=queue.get(i);
        }
        return sum*.10/Math.min(queue.size(), windowSize);
    }
}
