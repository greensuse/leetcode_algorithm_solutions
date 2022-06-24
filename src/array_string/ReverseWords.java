package array_string;

public class ReverseWords {
    public String reverseWords(String s) {
        String[] words=s.trim().split(" ");
        StringBuilder sb=new StringBuilder();
        for(int i=words.length-1; i>0; i--) {
            if(words[i].length()>0) {
                sb.append(words[i]).append(" ");
            }
        }
        sb.append(words[0]);
        return sb.toString();
    }
}
