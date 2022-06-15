package stack;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DecodeString_1 {
    public static void main(String[] args) {
        String s = "100[leetcode]";
        String result = decodeString(s);
        System.out.println(result);
    }
    public static String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char c1 = s.charAt(i);
            if(c1==']') {
                List<Character> chars = new LinkedList<>();
                Stack<Character> miniStack=new Stack<>();
                while(!stack.isEmpty()) {
                    char c2=stack.pop();
                    if(c2=='[') break;
                    miniStack.push(c2);
                }

                while(!miniStack.isEmpty()) {
                    chars.add(miniStack.pop());
                }
                StringBuilder sb = new StringBuilder();
                while(!stack.isEmpty()) {
                    if(stack.peek()>='0' && stack.peek()<='9') {
                        miniStack.push(stack.pop());
                     } else {
                        break;
                    }
                }

                while(!miniStack.isEmpty()) {
                    sb.append(miniStack.pop());
                }

                int repetition=Integer.valueOf(sb.toString());

                for(int j=0; j<repetition; j++) {
                    for(int k=0; k<chars.size(); k++) {
                        stack.push(chars.get(k));
                    }
                }
            } else {
                stack.push(c1);
            }
        }

        int totalChars=stack.size();
        char[] resultChars = new char[totalChars];

        for(int i=0; i<totalChars; i++) {
            resultChars[totalChars-i-1]=stack.pop();
        }

        return new String(resultChars);
    }
}
