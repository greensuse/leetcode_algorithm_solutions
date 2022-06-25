package hash_table;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map=new HashMap<>();

        for(int i=0; i<s.length(); i++) {
            if(map.get(s.charAt(i))==null) {
                map.put(s.charAt(i), t.charAt(i));
            } else {
                if(map.get(s.charAt(i))!=t.charAt(i)) {
                    return false;
                }
            }
        }
        map.clear();
        for(int i=0; i<t.length(); i++) {
            if(map.get(t.charAt(i))==null) {
                map.put(t.charAt(i), s.charAt(i));
            } else {
                if(map.get(t.charAt(i))!=s.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
