package binary_search;

public class Pow_x_n_1 {
    public static void main(String[] args) {
        double res=new Pow_x_n_1().myPow(2.0, 10);
        System.out.println(res);
    }

    public double myPow(double x, int n) {
        if(n==0) return 1;

        int N=n;
        if(n<0) {
            x=1/x;
            N=-N;
        }

        double ans=1;
        double current_product=x;
        for(int i=N; i>0; i=i/2) {
            if(i%2==1) {
                ans=ans*current_product;
            }
            current_product=current_product*current_product;
        }

        return ans;

    }
}
