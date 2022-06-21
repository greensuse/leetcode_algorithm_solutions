package array_string;

public class LargestCommonPrefix_2 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==1) return strs[0];

        String prefix = strs[0];

        for(int j=1; j<strs.length; j++) {
            while(strs[j].indexOf(prefix)!=0) {
                prefix=prefix.substring(0, prefix.length()-1);
            }
        }

        return prefix;
    }
}
