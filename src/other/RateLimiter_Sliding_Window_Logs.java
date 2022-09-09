package other;

import java.util.Date;

public class RateLimiter_Sliding_Window_Logs {
    long ts = 0;
    int token=4;
    Window window=new Window();
    boolean f(long timestamp) {
        ts=window.getLast().tm;
        if(timestamp-ts>6_000_000) {
            //clean window
            window.token=4;
            window.add(timestamp);
            return true;
        } else {
            while(timestamp-window.getFirst().tm>6_000_000) {
                //remove first;
                window.token--;
            }
            return window.token>0;
        }

    }
}

class Window {
    Node head=new Node(0);
    Node tail=new Node(0);

    int token=4;

    void add(long tm) {
        Node node=new Node(tm);
        node.prev=tail.prev;
        node.next=tail;
        tail.prev.next=node;
        tail.prev=node;
    }

    Node getLast() {return tail.prev;}
    Node getFirst() {return head.next;}
}

class Node {
    Node prev, next;
    long tm;

    Node(long _tm) {
        this.tm=_tm;
    }
}



