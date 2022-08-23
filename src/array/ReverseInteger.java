package array;

public class ReverseInteger {
    public static void main(String[] args) {
        int x=1534236469;
    }

    public int reverse(int x) {
        boolean isNegative=x<0;
        if(isNegative) x=-x;
        long res=0;
        while(x>0) {
            res=res*10+x%10;
            x/=10;
        }

        if(res>Integer.MAX_VALUE || res<Integer.MIN_VALUE) return 0;

        return isNegative?(int)-res:(int)res;
    }
}
