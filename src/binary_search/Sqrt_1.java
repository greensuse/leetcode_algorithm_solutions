package binary_search;

public class Sqrt_1 {
    public static void main(String[] args) {
        Sqrt_1 sqrt = new Sqrt_1();
        int result = sqrt.mySqrt(2147395599);
        System.out.println(result);
    }
    public int mySqrt(int x) {
        if(x==0 || x==1) return x;

        int start=2, end=x/2;
        int mid_val=0;
        long mid_val_square=0;
        while(start<=end) {
            mid_val=(start+end)/2;
            mid_val_square=(long)mid_val*mid_val;

            if(mid_val_square==x) {
                return mid_val;
            } else if(mid_val_square>x) {
                end=mid_val-1;
            } else {
                start=mid_val+1;
            }
        }

        return end;
    }
}
