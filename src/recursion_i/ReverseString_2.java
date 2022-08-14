package recursion_i;

public class ReverseString_2 {
    public void reverseString(char[] s) {
        int p1=0, p2=s.length-1;
        reverse(p1, p2, s);
    }

    private void reverse(int start, int end, char[] s) {
        if(start>=end) return;
        char tmp=s[start];
        s[start]=s[end];
        s[end]=tmp;
        reverse(start+1, end-1, s);
    }
}
