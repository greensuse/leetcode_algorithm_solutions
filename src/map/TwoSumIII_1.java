package map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TwoSumIII_1 {
    private Map<Integer, Integer> count;
    public TwoSumIII_1() {
        count=new HashMap<>();
    }

    public void add(int number) {
        count.put(number, count.getOrDefault(number, 0)+1);
    }

    public boolean find(int value) {
        Set<Integer> keys = count.keySet();
        for(int n : keys) {
            if(n*2!=value && count.get(value-n)!=null && count.get(value-n)>=1) {
                return true;
            } else if(n*2==value && count.get(value-n)!=null && count.get(value-n)==2) {
                return true;
            }
        }
        return false;
    }
}
