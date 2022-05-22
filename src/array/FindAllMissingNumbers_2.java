package array;

import java.util.LinkedList;
import java.util.List;

public class FindAllMissingNumbers_2 {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> result = findDisappearedNumbers(nums);
        System.out.println(result.toString());
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            int index=Math.abs(nums[i])-1;
            if(nums[index]>0) {
                nums[index] *= -1;
            }
        }

        List<Integer> missingNums = new LinkedList<>();
        for(int i=0; i<nums.length; i++) {
            if(nums[i]>0) missingNums.add(i+1);
        }
        return missingNums;
    }
}
