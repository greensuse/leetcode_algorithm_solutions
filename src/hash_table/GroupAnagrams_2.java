package hash_table;

import java.util.*;

public class GroupAnagrams_2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map=new HashMap<>();
        for(String str : strs) {
            int[] counts = new int[26];

            for(char c : str.toCharArray()) {
                counts[c-'a']++;
            }

            StringBuilder sb=new StringBuilder();
            for(int i=0; i<26; i++) {
                sb.append("#").append(counts[i]);
            }

            String key = sb.toString();

            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }

        return new ArrayList(map.values());
    }
}
