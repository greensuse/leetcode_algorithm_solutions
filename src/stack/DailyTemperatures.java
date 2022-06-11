package stack;

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res=new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();
        for(int i=0; i<temperatures.length; i++) {
            int[] temp = stack.size()>0?stack.peek():null;
            while(temp!=null && temperatures[i]>temp[1]) {
                stack.pop();
                res[temp[0]]=i-temp[0];
                temp = stack.size()>0?stack.peek():null;
            }
            stack.push(new int[]{i,temperatures[i]});
        }
        return res;
    }
}
