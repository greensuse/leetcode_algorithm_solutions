package map;

import java.util.LinkedList;

public class DesignHashSet {
    private Bucket[] buckets=new Bucket[1000];
    public static void main(String[] args) {
        DesignHashSet hashSet = new DesignHashSet();
        hashSet.add(1);
        hashSet.add(2);
        System.out.println(hashSet.contains(1));
        System.out.println(hashSet.contains(3));
        hashSet.add(2);
        System.out.println(hashSet.contains(2));
        hashSet.remove(2);
        System.out.println(hashSet.contains(2));
    }

    public void add(int key) {
        int index=key%1000;
        if(buckets[index]==null) {
            Bucket bucket=new Bucket();
            bucket.add(key);
            buckets[index]=bucket;
        } else {
            Bucket bucket=buckets[index];
            bucket.add(key);
        }
    }

    public void remove(int key) {
        int index=key%1000;
        if(buckets[index]!=null) {
            Bucket bucket=buckets[index];
            bucket.remove(key);
        }
    }

    public boolean contains(int key) {
        int index=key%1000;
        if(buckets[index]==null) {
            return false;
        } else {
            Bucket bucket=buckets[index];
            return bucket.contains(key);
        }
    }

    private class Bucket {
        LinkedList<Integer> container = null;
        public Bucket() {
            container=new LinkedList<>();
        }

        public void add(int key) {
            if(container.indexOf(key)<0) {
                container.add(key);
            }
        }

        public void remove(int key) {
            if(container.size()>0) {
                container.removeFirstOccurrence(key);
            }
        }

        public boolean contains(int key) {
            return container.indexOf(key)>=0;
        }
    }
}
