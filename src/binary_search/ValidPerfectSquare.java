package binary_search;

public class ValidPerfectSquare {
    public static void main(String[] args) {
        boolean answer = new ValidPerfectSquare().isPerfectSquare(808201);
        System.out.println(answer);
    }
    public boolean isPerfectSquare(int num) {
        if(num<=1) return true;

        long left=2, right=num/2;

        while(left<=right) {
            long mid=left+(right-left)/2;

            long mid_square=mid*mid;

            if(mid_square==num) {
                return true;
            } else if(mid_square>num) {
                right=mid-1;
            } else {
                left=mid+1;
            }
        }

        return false;
    }
}
