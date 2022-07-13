package binary_search;

public class GuessNumberHigherLower {
    public static void main(String[] args) {
        int range=2126753390;
        int res=new GuessNumberHigherLower().guessNumber(range);
        System.out.println(res);

    }
    public int guessNumber(int n) {
        int start=1, end=n, mid=0;
        while(start<=end) {
            mid=start+(end-start)/2;
            int res=guess(mid);
            if(res==0) return mid;
            else if(res==-1) end=mid-1;
            else if(res==1) start=mid+1;
        }

        return mid;
    }

    private int guess(int val) {
        if(val==1702766719) return 0;
        else if(val>1702766719) return -1;
        else return 1;
    }
}
