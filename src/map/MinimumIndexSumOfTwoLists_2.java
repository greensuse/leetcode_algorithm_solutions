package map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumIndexSumOfTwoLists_2 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int min_index=Integer.MAX_VALUE;
        List<String> restaurants = new ArrayList<>();
        Map<String, Integer> list1_map=new HashMap<>();
        for(int i=0; i<list1.length; i++) {
            list1_map.put(list1[i], i);
        }

        for(int j=0; j<list2.length; j++) {
            Integer index=list1_map.get(list2[j]);
            if(index!=null) {
                if(index+j<min_index) {
                    min_index=index+j;
                    restaurants.clear();
                    restaurants.add(list2[j]);
                } else if(index+j==min_index) {
                    restaurants.add(list2[j]);
                }
            }
        }

        return restaurants.toArray(new String[restaurants.size()]);
    }
}
