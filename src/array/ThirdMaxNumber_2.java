package array;

public class ThirdMaxNumber_2 {
    public static void main(String[] args) {
        int[] nums= {1,2,2,5,3,5};
        int result  = thirdMax(nums);
        System.out.println(result);
    }

    public static int thirdMax(int[] nums) {
        Integer firstMax=null, secondMax=null, thirdMax=null;

        for(Integer val : nums) {
            if(val.equals(firstMax) || val.equals(secondMax) || val.equals(thirdMax)) continue;

            if(firstMax==null || val>firstMax) {
                thirdMax=secondMax;
                secondMax=firstMax;
                firstMax=val;
            } else if(secondMax==null || (val<firstMax && val>secondMax)) {
                thirdMax=secondMax;
                secondMax=val;
            } else if(thirdMax==null || (val<secondMax && val>thirdMax)) {
                thirdMax=val;
            }
        }

        return thirdMax!=null?thirdMax:firstMax;
    }
}
