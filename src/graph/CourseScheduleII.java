package graph;

import java.util.*;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList=new HashMap<>(numCourses);
        int[] inDegree=new int[numCourses];
        int[] toplogicalOrder=new int[numCourses];

        //create the adjacency list representation of the graph
        for(int[] prerequisite : prerequisites) {
            int dst=prerequisite[0];
            int src=prerequisite[1];
            List<Integer> lst=adjList.getOrDefault(src, new LinkedList<Integer>());
            lst.add(dst);
            adjList.put(src, lst);

            //record in-degree of each vertex
            inDegree[dst]+=1;
        }

        //Add all vertices with 0 in-degree to the queue
        Queue<Integer> queue=new LinkedList<Integer>();
        for(int i=0; i<numCourses; i++) {
            if(inDegree[i]==0) {
                queue.offer(i);
            }
        }

        int i=0;
        //process until the Q becomes empty
        while(!queue.isEmpty()) {
            int node=queue.poll();
            toplogicalOrder[i++]=node;

            //reduce the in-degree of each neighbor by 1
            if(adjList.containsKey(node)) {
                for(int dst: adjList.get(node)) {
                    inDegree[dst]-=1;
                    if(inDegree[dst]==0) {
                        queue.offer(dst);
                    }
                }
            }

        }

        if(i==numCourses) return toplogicalOrder;

        return new int[0];
    }
}
