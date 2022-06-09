package queue;

import java.util.*;

public class OpenTheLock_1 {

    public static void main(String[] args) {
        String[] deadends = new String[]{"0201","0101","0102","1212","2002"};
        String target="0202";

        int result = openLock(deadends, target);
        System.out.println(result);
    }

    public static int openLock(String[] deadends, String target) {
        Set<String> deads=new HashSet(Arrays.asList(deadends));
        Set<String> seen=new HashSet<>();

        int steps=0;
        Queue<String> queue= new LinkedList<>();
        queue.offer("0000");
        queue.offer(null);

        while(!queue.isEmpty()) {
            String node=queue.poll();

            if(node==null) {
                steps++;
                String val = queue.peek();
                if(queue.peek()!=null) {
                    queue.offer(null);
                }
            } else if(node.equals(target)) {
                return steps;
            } else if(!deads.contains(node)) {
                for(int i=0; i<4; i++) {
                    String rollForward = node.substring(0, i) +(node.charAt(i) - '0' + 1 +10)%10+node.substring(i+1);
                    String rollBackward = node.substring(0, i) +(node.charAt(i) - '0' - 1 +10)%10+node.substring(i+1);
                    if(!seen.contains(rollForward)) {
                        queue.offer(rollForward);
                        seen.add(rollForward);
                    }
                    if(!seen.contains(rollBackward)) {
                        queue.offer(rollBackward);
                        seen.add(rollBackward);
                    }
                }
            }
        }

        return -1;
    }
}
