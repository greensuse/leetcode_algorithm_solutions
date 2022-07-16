package binary_search;

public class Pow_x_n_3 {
    public static void main(String[] args) {
        double res=new Pow_x_n_3().myPow(2.0, 10);
        System.out.println(res);
    }

    public double myPow(double x, int n) {
        long nn=n;
        if(n<0) {
            x=1/x;
            nn=-nn;
        }
        return pow(x, nn);
    }

    private double pow(double x, long n) {
        if(n==0) return 1;
        else if(n%2==0) {
            double y=pow(x, n/2);
            return y*y;
        } else {
            return x*pow(x, n-1);
        }
    }
}
