package decision_tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CalculateMaxInfoGain {
    public static void main(String[] args) {
        double[] petal_length={0.5, 2.3, 1.5, 1.0, 2.0};
        String[] species={"setosa", "versicolor", "versicolor", "setosa", "versicolor"};

        CalculateMaxInfoGain obj=new CalculateMaxInfoGain();
        double result = obj.calculateMaxInfoGain(petal_length, species);
        System.out.println(result);
    }

    public double calculateMaxInfoGain(double[] petal_length, String[] species) {
        if(petal_length.length==0 || species.length==0) return 0;

        System.out.println(Arrays.toString(petal_length));
        System.out.println(Arrays.toString(species));

        int n=petal_length.length;
        double Hs = Double.MAX_VALUE;

        TreeMap<DNode, DNode> map=new TreeMap<>();
        for(int i=0; i<n; i++) {
            DNode node = new DNode(petal_length[i], species[i]);
            map.put(node, node);
        }
        String[] species_sorted=new String[n];
        int index=0;
        for(DNode d : map.keySet()) {
            species_sorted[index++]=map.get(d).species;
        }

        System.out.println(Arrays.toString(species_sorted));

        for(int i=1; i<n; i++) {
            double H1=calculateEntropy(Arrays.copyOfRange(species_sorted, 0, i));
            double H2=calculateEntropy(Arrays.copyOfRange(species_sorted, i, n));
            Hs=Math.min(Hs, H1*i/n+H2*(n-i)/n);
        }
        double H1=calculateEntropy(species_sorted);
        return H1-Hs;
    }

    private double calculateEntropy(String[] input) {
        Map<String, Integer> map=new HashMap<>();
        for(String val : input) {
            map.put(val, map.getOrDefault(val, 0)+1);
        }
        double result=0;
        int n=input.length;
        for(String key : map.keySet()) {
            int count=map.get(key);
            double p=count*1.0/n;
            result-=p*Math.log(p)/Math.log(2);
        }
        return result;
    }
}
