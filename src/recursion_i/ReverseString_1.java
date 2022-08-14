package recursion_i;

public class ReverseString_1 {
    public void reverseString(char[] s) {
        int p1=0, p2=s.length-1;
        while(p1<p2) {
            char temp=s[p2];
            s[p2]=s[p1];
            s[p1]=temp;
            p1++;
            p2--;
        }
    }
}
