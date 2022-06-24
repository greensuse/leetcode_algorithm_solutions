package hash_table;

import java.util.LinkedList;

public class DesignHashMap {

    private Bucket[] buckets=null;
    public DesignHashMap() {
        buckets=new Bucket[1000];
    }

    public void put(int key, int value) {
        int index=key%1000;
        Bucket bucket = buckets[index];
        if(bucket!=null) {
            bucket.put(key, value);
        } else {
            bucket=new Bucket();
            bucket.put(key,value);
            buckets[index]=bucket;
        }

    }

    public int get(int key) {
        int index=key%1000;
        Bucket bucket = buckets[index];
        if(bucket==null) return -1;

        return bucket.get(key);
    }

    public void remove(int key) {
        int index=key%1000;
        Bucket bucket = buckets[index];
        if(bucket!=null) bucket.remove(key);

    }

    private class Bucket {
        private LinkedList<Pair> container;

        public Bucket() {
            container = new LinkedList<>();
        }

        public void put(int key, int value) {
            int index = -1;

            for(int i=0; i<container.size(); i++) {
                Pair pair = container.get(i);
                if(pair.key==key) {
                    index=i;
                    break;
                }
            }
            if(index<0) {
                container.add(new Pair(key, value));
            } else {
                container.set(index, new Pair(key, value));
            }
        }

        public int get(int key) {
            int index = -1;

            for(int i=0; i<container.size(); i++) {
                Pair pair = container.get(i);
                if(pair.key==key) {
                    return pair.value;
                }
            }

            return -1;
        }

        public void remove(int key) {
            int index = -1;

            for(int i=0; i<container.size(); i++) {
                Pair pair = container.get(i);
                if(pair.key==key) {
                    index=i;
                    break;
                }
            }
            if(index>=0) {
                container.remove(index);
            }
        }
    }

    private class Pair {
        int key, value;

        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }
}
