package map;

public class HappyNumber {
    public boolean isHappy(int n) {
        if(n==1) return true;

        int slow=n;
        int fast=getNext(n);

        while(fast!=1) {
            slow=getNext(slow);
            fast=getNext(getNext(fast));

            if(slow==fast) break;
        }

        return fast==1;
    }

    private int getNext(int n) {
        int mod=0;
        int res=0;
        while(n>0) {
            mod=n%10;
            res+=mod*mod;
            n=n/10;
        }
        return res;
    }
}
