package hash_table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map=new HashMap<>();

        for(String key : strings) {
            String pattern = findPattern(key);
            if(!map.containsKey(pattern)) {
                map.put(pattern, new ArrayList<>());
            }

            map.get(pattern).add(key);
        }

        return new ArrayList<>(map.values());
    }

    private String findPattern(String key) {
        String pattern="";
        if(key.length()==1) {
            pattern=",";
        } else if(key.length()>1) {
            StringBuilder sb = new StringBuilder();
            char[] chars=key.toCharArray();
            for(int i=0;i<chars.length-1; i++) {
                if(chars[i+1]-chars[i]>=0) {
                    sb.append(chars[i+1]-chars[i]).append(",");
                } else {
                    sb.append(chars[i+1]-chars[i]+26).append(",");
                }
            }
            pattern=sb.toString();
        }
        return pattern;
    }
}
