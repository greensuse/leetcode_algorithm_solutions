package stack;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DecodeString_2 {
    public static void main(String[] args) {
        String s = "100[leetcode]";
        String result = decodeString(s);
        System.out.println(result);
    }
    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            int count=0;
            Character c1 = s.charAt(i);
            while(Character.isDigit(c1)) {
                count=10*count+c1-'0';
                i++;
                c1 = s.charAt(i);
            }

            if(count>0) {
                countStack.push(count);
            }

            if(c1==']') {
                String res="";
                while(!stringStack.peek().equals("[")) {
                    res=stringStack.pop()+res;
                }
                //pop up "["
                stringStack.pop();

                StringBuilder sb=new StringBuilder();
                count=countStack.pop();
                for(int j=0; j<count; j++) {
                    sb.append(res);
                }
                stringStack.push(sb.toString());
            } else {
                stringStack.push(Character.toString(c1));
            }

        }

        String sb2 = "";
        while(!stringStack.isEmpty()) {
            sb2 = stringStack.pop()+sb2;
        }
        return sb2;
    }
}
