package dynamic_programming;

public class KnightDialer_1 {
    public static void main(String[] args) {
        int res=new KnightDialer_1().knightDialer(3131);
        System.out.println(res);
    }

    public int knightDialer(int n) {
        int[] dp=new int[10];
        for(int i=0; i<10; i++) dp[i]=1;
        int[] dp_old=new int[10];

        int MOD=1000_000_007;

        for(int i=2; i<=n; i++) {
            for(int j=0; j<10; j++) dp_old[j]=dp[j];

            dp[0]=dp_old[4]+dp_old[6];
            dp[1]=dp_old[8]+dp_old[6];
            dp[2]=dp_old[7]+dp_old[9];
            dp[3]=dp_old[4]+dp_old[8];
            dp[4]=(dp_old[3]+dp_old[9])%MOD+dp_old[0];
            dp[5]=0;
            dp[6]=(dp_old[1]+dp_old[7])%MOD+dp_old[0];
            dp[7]=dp_old[2]+dp_old[6];
            dp[8]=dp_old[1]+dp_old[3];
            dp[9]=dp_old[4]+dp_old[2];

            for(int k=0; k<10; k++) {
                dp[k]%=MOD;
            }
        }
        int res=0;
        for(int val : dp) {
            res+=val;
            res%=MOD;
        }

        return res;
    }
}
