package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a1, int[] a2) {
                return a1[0]-a2[0];
            }
        });

        PriorityQueue<int[]> queue=new PriorityQueue<>(
                new Comparator<int[]>(){
                    public int compare(int[] a1, int[] a2) {
                        return a1[1]-a2[1];
                    }
                });

        int room_num=0;
        for(int i=0; i<intervals.length; i++) {
            int[] interval=intervals[i];
            int[] queue_interval=queue.peek();
            if(queue_interval==null || queue_interval[1]>interval[0]) {
                queue.offer(interval);
                room_num++;
            } else if(queue_interval[1]<=interval[0]) {
                queue.poll();
                queue.offer(interval);
            }
        }

        return room_num;
    }
}
