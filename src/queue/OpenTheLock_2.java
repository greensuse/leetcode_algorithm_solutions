package queue;

import java.util.*;

public class OpenTheLock_2 {

    public static void main(String[] args) {
        String[] deadends = new String[]{"0201","0101","0102","1212","2002"};
        String target="0202";

        int result = openLock(deadends, target);
        System.out.println(result);
    }

    public static int openLock(String[] deadends, String target) {
        Set<String> dead_ends=new HashSet(Arrays.asList(deadends));
        Set<String> visited=new HashSet<>();

        int steps=0;
        Queue<String> queue= new LinkedList<>();
        queue.offer("0000");
        visited.add("0000");

        while(!queue.isEmpty()) {
            int size=queue.size();
            for(int i=0; i<size; i++) {
                String node = queue.poll();

                if(dead_ends.contains(node)) {
                    continue;
                } else if(target.equals(node)) {
                    return steps;
                } else {
                    for(int j=0; j<4; j++) {
                        String forward=node.substring(0,j)+(node.charAt(j)-'0'+1+10)%10+node.substring(j+1);
                        if(!dead_ends.contains(forward) && !visited.contains(forward)) {
                            queue.offer(forward);
                            visited.add(forward);
                        }
                        String backward=node.substring(0,j)+(node.charAt(j)-'0'-1+10)%10+node.substring(j+1);
                        if(!dead_ends.contains(backward) && !visited.contains(backward)) {
                            queue.offer(backward);
                            visited.add(backward);
                        }
                    }
                }
            }
            steps++;
        }

        return -1;
    }
}
