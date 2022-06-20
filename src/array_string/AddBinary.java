package array_string;

public class AddBinary {
    public static void main(String[] args) {
        String s1="1010", s2="1011";
        String result = addBinary(s1, s2);
        System.out.println(result);
    }
    public static String addBinary(String a, String b) {
        int i=a.length()-1, j=b.length()-1;
        int sum=0, carry=0;
        StringBuilder sb=new StringBuilder();
        while(i>=0 || j>=0) {
            sum=carry;
            if(i>=0) {
                sum+=a.charAt(i)-'0';
            }
            if(j>=0) {
                sum+=b.charAt(j)-'0';
            }
            carry=sum/2;
            sum=sum%2;
            sb.append(sum);
            i--;
            j--;
        }
        if(carry>0) {
            sb.append(carry);
        }
        String result = sb.reverse().toString();
        return result;
    }
}
