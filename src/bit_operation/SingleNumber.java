package bit_operation;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int res=0;
        for(int num : nums) {
            res^=num;
        }
        return res;
    }
}
