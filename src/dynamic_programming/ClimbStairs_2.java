package dynamic_programming;

//bottom-up implementation
public class ClimbStairs_2 {
    public int climbStairs(int n) {
        if(n==1) return 1;

        int[] steps=new int[n+1];
        steps[1]=1; // Base cases
        steps[2]=2; // Base cases
        for(int i=3; i<=n; i++) {
            steps[i]=steps[i-1]+steps[i-2];
        }
        return steps[n];
    }
}
