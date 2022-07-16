package binary_search;

public class Pow_x_n_2 {
    public static void main(String[] args) {
        double res=new Pow_x_n_2().myPow(2.0, 10);
        System.out.println(res);
    }

    public double myPow(double x, int n) {
        if(n==0) return 1;
        if(n==1) return x;

        long N=n;
        if(N<0) {
            x=1/x;
            N=-N;
        }

        double result=1;
        while(N>0) {
            if(N%2==1) {
                result*=x;
                N-=1;
            } else {
                x*=x;
                N=N/2;
            }
        }

        return result;
    }
}
