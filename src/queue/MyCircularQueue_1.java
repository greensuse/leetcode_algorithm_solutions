package queue;

public class MyCircularQueue_1 {

    private int[] queue;
    private int headIndex;
    private int count;
    private int capacity;

    public MyCircularQueue_1(int k) {
        this.capacity = k;
        this.queue = new int[k];
        this.headIndex=0;
        this.count=0;
    }

    public boolean enQueue(int value) {
        if(count==capacity) return false;

        int index=(headIndex+count)%capacity;
        queue[index]=value;

        count++;
        return true;
    }

    public boolean deQueue() {
        if(count==0) return false;

        headIndex=(headIndex+1)%capacity;
        count--;
        return true;
    }

    public int Front() {
        if(count==0) return -1;
        return queue[headIndex];
    }

    public int Rear() {
        if(count==0) return -1;
        int tailIndex=(headIndex+count-1)%count;
        return queue[tailIndex];
    }

    public boolean isEmpty() {
        return count==0;
    }

    public boolean isFull() {
        return count==capacity;
    }


}
