package array_string;

public class PlusOne_2 {
    public int[] plusOne(int[] digits) {
        for(int i=digits.length-1; i>=0; i--) {
            if(digits[i]==9) {
                digits[i]=0;
            } else {
                digits[i]++;
                return digits;
            }
        }

        int[] newDigits=new int[digits.length+1];
        newDigits[0]=1;
        return newDigits;
    }
}
