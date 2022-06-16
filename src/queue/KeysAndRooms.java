package queue;

import java.util.*;

public class KeysAndRooms {
    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<List<Integer>>();
        rooms.add(Arrays.asList(new Integer[]{1}));
        rooms.add(Arrays.asList(new Integer[]{2}));
        rooms.add(Arrays.asList(new Integer[]{3}));
        rooms.add(Arrays.asList(new Integer[]{}));

        boolean result = canVisitAllRooms(rooms);
        System.out.println(result);
    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int[] visited=new int[rooms.size()];
        Queue<Integer> queue=new LinkedList<>();

        for(int index : rooms.get(0)) {
            queue.offer(index);
        }
        visited[0]=1;

        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-->0) {
                int index = queue.poll();
                visited[index]=1;
                for(int index2 : rooms.get(index)) {
                    if(visited[index2]==0) {
                        queue.offer(index2);
                    }
                }
            }
        }

        for(int i=0; i<visited.length; i++) {
            if(visited[i]==0) {
                return false;
            }
        }

        return true;
    }
}
