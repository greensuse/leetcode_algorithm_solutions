package array;

public class RemoveElement_1 {

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;

        int result = removeElement(nums, val);
        System.out.println(result);
    }

    public static int removeElement(int[] nums, int val) {
        int size = nums.length;

        int leftIndex=0, rightIndex=size-1;
        int occurance=0;

        while(leftIndex<=rightIndex) {
            if(nums[leftIndex]==val && nums[rightIndex]!=val) {
                occurance++;
                nums[leftIndex]=nums[rightIndex];
                leftIndex++;
                rightIndex--;
            } else if(nums[rightIndex]==val) {
                occurance++;
                rightIndex--;
            } else {
                leftIndex++;
            }

        }

        return size-occurance;
    }
}
