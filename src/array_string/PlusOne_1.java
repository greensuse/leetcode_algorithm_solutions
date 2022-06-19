package array_string;

public class PlusOne_1 {
    public int[] plusOne(int[] digits) {
        int over=1;
        int length=digits.length;

        for(int i=digits.length-1; i>=0; i--) {
            if(digits[i]+over<10) {
                digits[i]+=over;
                over=0;
            } else {
                digits[i]=0;
                over=1;
            }
        }

        if(over==1) {
            int[] newDigits=new int[digits.length+1];
            newDigits[0]=1;
            for(int j=0; j<length; j++) {
                newDigits[j+1]=digits[j];
            }
            return newDigits;
        } else {
            return digits;
        }
    }
}
