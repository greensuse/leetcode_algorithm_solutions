package queue;

import java.util.concurrent.locks.ReentrantLock;

public class MyCircularQueue_2 {

    private Node head, tail;
    private int count;
    private int capacity;
    // Additional variable to secure the access of our queue
    private ReentrantLock queueLock = new ReentrantLock();

    public MyCircularQueue_2(int k) {
        this.capacity = k;
        this.count=0;
    }

    public boolean enQueue(int value) {
        queueLock.lock();
        try {
            if (count == capacity) return false;

            Node newNode = new Node(value);
            if(count==0) {
                head=tail=newNode;
            } else {
                tail.nextNode=newNode;
                tail=newNode;
            }

            count++;
        }finally{
            queueLock.unlock();
        }
        return true;
    }

    public boolean deQueue() {
        queueLock.lock();
        try {
            if (count == 0) return false;
            head=head.nextNode;
            count--;
        }finally{
            queueLock.unlock();
        }
        return true;
    }

    public int Front() {
        if(count==0) return -1;
        return head.value;
    }

    public int Rear() {
        if(count==0) return -1;
        return tail.value;
    }

    public boolean isEmpty() {
        return count==0;
    }

    public boolean isFull() {
        return count==capacity;
    }

    class Node {
        public int value;
        public Node nextNode;

        public Node(int value) {
            this.value = value;
            this.nextNode = null;
        }
    }
}
