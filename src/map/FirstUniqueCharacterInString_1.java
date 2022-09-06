package map;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInString_1 {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map=new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            if(map.get(s.charAt(i))==null) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            }
        }

        for(int i=0; i<s.length(); i++) {
            if(map.get(s.charAt(i))==1) {
                return i;
            }
        }

        return -1;
    }
}
