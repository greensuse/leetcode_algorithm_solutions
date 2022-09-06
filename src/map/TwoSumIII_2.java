package map;

import java.util.HashMap;
import java.util.Map;

public class TwoSumIII_2 {
    public static void main(String[] args) {
        TwoSumIII_2 twoSum = new TwoSumIII_2();
        twoSum.add(0);
        twoSum.add(0);
        boolean res=twoSum.find(0);
        System.out.println(res);
    }
    private Map<Integer, Integer> count;
    public TwoSumIII_2() {
        count=new HashMap<>();
    }

    public void add(int number) {
        count.put(number, count.getOrDefault(number, 0)+1);
    }

    public boolean find(int value) {
        for(Map.Entry<Integer, Integer> n : count.entrySet()) {
            int key=n.getKey();
            int complement = value-key;
            if(complement!=key && count.containsKey(complement)) {
                return true;
            } else if(complement==key &&  n.getValue()>1) {
                return true;
            }
        }
        return false;
    }
}
