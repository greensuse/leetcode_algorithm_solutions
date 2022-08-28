package design;

import java.util.*;

public class RandomizedSet {
    Map<Integer, Integer> dict;
    List<Integer> list;
    Random random = new Random();

    public RandomizedSet() {
        dict=new HashMap<Integer, Integer>();
        list=new ArrayList<Integer>();
    }

    public boolean insert(int val) {
        if(dict.containsKey(val)) return false;

        dict.put(val, list.size());
        list.add(list.size(), val);

        return true;
    }

    public boolean remove(int val) {
        if(!dict.containsKey(val)) return false;

        int index=dict.get(val);
        list.set(index, list.get(list.size() - 1));
        dict.put(list.get(index), index);

        //remove val
        list.remove(list.size() - 1);
        dict.remove(val);

        return true;
    }

    public int getRandom() {
        int index=random.nextInt(this.list.size());
        return list.get(index);
    }
}
