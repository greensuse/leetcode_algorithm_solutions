package map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache_2  {
    class DLinkedNode {
        int key, value;
        DLinkedNode prev, next;
        DLinkedNode(){}
        DLinkedNode(int key, int val) {
            this.key=key;
            this.value=val;
        }
    }

    private int size, capacity;
    private Map<Integer, DLinkedNode> cache;
    private DLinkedNode head, tail;
    public LRUCache_2() {
        this.size = 0;
        this.capacity=capacity;
        cache=new HashMap<Integer, DLinkedNode>(capacity);
        head=new DLinkedNode();
        tail=new DLinkedNode();
        head.next=tail;
        tail.prev=head;
    }



    public int get(int key) {
        DLinkedNode node =  cache.get(key);
        if(node==null) return -1;
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node =  cache.get(key);
        if(node==null) {
            node=new DLinkedNode(key, value);
            cache.put(key, node);
            addNode(node);
            size++;
            if(size>capacity) {
                DLinkedNode tail = popTail();
                cache.remove(tail.key);
                size--;
            }
        } else {
            node.value=value;
            moveToHead(node);
        }
    }

    private void moveToHead(DLinkedNode node) {
        remove(node);
        addNode(node);
    }

    private void addNode(DLinkedNode node) {
        node.prev=head;
        node.next=head.next;
        head.next.prev=node;
        head.next=node;
    }

    private void remove(DLinkedNode node) {
        DLinkedNode prev=node.prev;
        DLinkedNode next=node.next;
        prev.next=next;
        next.prev=prev;
    }

    private DLinkedNode popTail() {
        DLinkedNode prev=tail.prev;
        remove(prev);
        return prev;
    }
}
