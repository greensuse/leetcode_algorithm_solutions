package array;

public class ThirdMaxNumber_1 {
    public static void main(String[] args) {
        int[] nums= {1,2,2,5,3,5};
        int result  = thirdMax(nums);
        System.out.println(result);
    }

    public static int thirdMax(int[] nums) {
        long firstMax=Long.MIN_VALUE, secondMax=Long.MIN_VALUE, thirdMax=Long.MIN_VALUE;

        for(int val : nums) {
            if(val==firstMax || val==secondMax || val==thirdMax) continue;

            if(val>firstMax) {
                thirdMax=secondMax;
                secondMax=firstMax;
                firstMax=val;
            } else if(val<firstMax && val>secondMax) {
                thirdMax=secondMax;
                secondMax=val;
            } else if(val<secondMax && val>thirdMax) {
                thirdMax=val;
            }
        }

        return thirdMax!=Long.MIN_VALUE?(int)thirdMax:(int)firstMax;
    }
}
