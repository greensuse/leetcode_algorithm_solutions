package map;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> jewel_set=new HashSet<>();
        for(char c : jewels.toCharArray()) {
            jewel_set.add(c);
        }

        int count=0;
        for(char c : stones.toCharArray()) {
            if(jewel_set.contains(c)) count++;
        }

        return count;
    }
}
