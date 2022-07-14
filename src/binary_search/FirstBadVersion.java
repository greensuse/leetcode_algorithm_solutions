package binary_search;

public class FirstBadVersion {
    public static void main(String[] args) {
        int result = new FirstBadVersion().firstBadVersion(2126753390);
        System.out.println(result);
    }
    public int firstBadVersion(int n) {
        int left=1, right=n;
        while(left<right) {
            int mid=left+(right-left)/2;
            if(this.isBadVersion(mid)) {
                right=mid;
            } else {
                left=mid+1;
            }
        }

        return left;
    }

    private boolean isBadVersion(int val) {
        if(val>=1702766719) {
            return true;
        }
        return false;
    }
}
