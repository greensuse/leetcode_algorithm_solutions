package matrix;

import java.util.HashMap;
import java.util.Map;

public class SparseVector {
    Map<Integer, Integer> indexValueMap;
    SparseVector(int[] nums) {
        indexValueMap=new HashMap<>(nums.length);
        for(int i=0; i<nums.length; i++) {
            if(nums[i]!=0) {
                indexValueMap.put(i, nums[i]);
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int product=0;
        for(int val : indexValueMap.keySet()) {
            if(vec.indexValueMap.containsKey(val)) {
                product+=indexValueMap.get(val)*vec.indexValueMap.get(val);
            }
        }
        return product;
    }
}

