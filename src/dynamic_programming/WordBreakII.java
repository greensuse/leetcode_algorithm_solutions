package dynamic_programming;

import java.util.*;

public class WordBreakII {
    public static void main(String[] args) {
        String s="pineapplepenapple";
        List<String> wordDict= Arrays.asList("apple","pen","applepen","pine","pineapple");
        List<String> res=new WordBreakII().wordBreak(s, wordDict);
        System.out.println(res);
    }
    private List<String> wordDict=new ArrayList<>();

    private Map<String, List<String>> memo=new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        this.wordDict=wordDict;
        return DFS(s);
    }

    private List<String> DFS(String s) {
        if(memo.containsKey(s)) return memo.get(s);

        List<String> res=new ArrayList<>();
        if(s.length()==0) {
            res.add("");
            return res;
        }

        for(String word : wordDict) {
            if(s.startsWith(word)) {
                List<String> subList=DFS(s.substring(word.length()));
                for(String sub : subList) {
                    res.add(word+""+(sub.isEmpty()?"":" ")+sub);
                }
            }
        }

        memo.put(s, res);

        return res;
    }
}
