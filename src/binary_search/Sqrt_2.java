package binary_search;

public class Sqrt_2 {
    public static void main(String[] args) {
        Sqrt_2 sqrt = new Sqrt_2();
        int result = sqrt.mySqrt(2147395599);
        System.out.println(result);
    }
    public int mySqrt(int x) {
        if(x<2) return x;

        int start=1, end=x;
        int mid=0, res=0;
        while(start<=end) {
            mid=(start+end)/2;

            if(mid<=x/mid) {
                res=mid;
                start=mid+1;
            } else {
                end=mid-1;
            }
        }

        return res;
    }
}
