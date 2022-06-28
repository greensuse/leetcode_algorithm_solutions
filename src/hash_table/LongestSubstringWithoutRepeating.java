package hash_table;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeating {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()<=1) return s.length();

        Map<Character, Integer> map=new HashMap<>();
        int max_length=0;
        char[] chars=s.toCharArray();
        for(int j=0, i=0; j<chars.length; j++) {
            if(map.containsKey(chars[j])) {
                i=Math.max(map.get(chars[j])+1, i);
            }

            max_length=Math.max(j-i+1, max_length);
            map.put(chars[j], j);
        }

        return max_length;
    }
}
