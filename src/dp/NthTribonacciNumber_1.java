package dp;

public class NthTribonacciNumber_1 {
    public int tribonacci(int n) {
        if(n==0) return 0;
        if(n<3) return 1;
        int[] f=new int[n+1];
        f[0]=0;
        f[1]=1;
        f[2]=1;

        for(int i=3; i<=n; i++) {
            f[i]=f[i-3]+f[i-2]+f[i-1];
        }

        return f[n];
    }
}
