package array_string;

public class LargestCommonPrefix_1 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==1) return strs[0];

        int minLen=Integer.MAX_VALUE;

        for(String str: strs) {
            if(str.length()<minLen) {
                minLen=str.length();
            }
        }

        int common_prefix_len=0;

        for(int i=0; i<minLen; i++) {
            char c= strs[0].charAt(i);

            for(int j=1; j<strs.length; j++) {
                if(strs[j].charAt(i)!=c) {
                    return strs[0].substring(0, common_prefix_len);
                }
            }

            common_prefix_len++;
        }

        return strs[0].substring(0, common_prefix_len);
    }
}
