package map;

import java.util.HashMap;
import java.util.Map;

public class UniqueWordAbbreviation {
    Map<String, String> map=new HashMap<>();

    public UniqueWordAbbreviation(String[] dictionary) {
        for(String word : dictionary) {
            String abbr = getAbbr(word);
            if(map.containsKey(abbr) && !map.get(abbr).equals(word)) {
                map.put(abbr, "");
            } else {
                map.put(abbr, word);
            }
        }
    }

    public boolean isUnique(String word) {
        String abbr = getAbbr(word);
        return !map.containsKey(abbr) || map.get(abbr).equals(word);
    }

    private String getAbbr(String word) {
        int length=word.length();
        if(length<=2) return word;

        return word.charAt(0)+String.valueOf(length-2)+word.charAt(length-1);
    }
}
