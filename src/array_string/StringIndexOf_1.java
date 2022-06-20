package array_string;

public class StringIndexOf_1 {
    public int strStr(String haystack, String needle) {

        for(int i=0; i<haystack.length(); i++) {
            if(needle.length()>haystack.length()-i) return -1;

            if(haystack.charAt(i)==needle.charAt(0)) {
                boolean allMatch=true;

                for(int j=1; j<needle.length(); j++) {
                    if(needle.charAt(j)!=haystack.charAt(i+j)) {
                        allMatch=false;
                        break;
                    }
                }
                if(allMatch) return i;
                else continue;
            } else {
                continue;
            }
        }
        return -1;
    }
}
