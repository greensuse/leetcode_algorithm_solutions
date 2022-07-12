package decision_tree;

import java.util.HashMap;
import java.util.Map;

public class CalculateEntropy {
    public double calculateEntropy(int[] input) {
        Map<Integer, Integer> map=new HashMap<>();
        for(int val : input) {
            map.put(val, map.getOrDefault(val, 0)+1);
        }
        double result=0;
        int n=input.length;
        for(int key : map.keySet()) {
            int count=map.get(key);
            double p=count*1.0/n;
            result-=p*Math.log(p)/Math.log(2);
        }
        return result;
    }
}
