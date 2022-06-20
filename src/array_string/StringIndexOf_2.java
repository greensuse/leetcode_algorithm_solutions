package array_string;

public class StringIndexOf_2 {
    public int strStr(String haystack, String needle) {
        for(int i=0; i<haystack.length(); i++) {
            if(needle.length()>haystack.length()-i) return -1;

            if(haystack.charAt(i)==needle.charAt(0)) {
                int len=1;

                while(len<needle.length() && needle.charAt(len)==haystack.charAt(i+len)) {
                    len++;
                }
                if(len==needle.length()) return i;
            }
        }
        return -1;
    }
}
