package stack;

import java.util.List;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int[] visited=new int[rooms.size()];

        visit(rooms, 0, visited);

        for(int i=0; i<visited.length; i++) {
            if(visited[i]==0) {
                return false;
            }
        }

        return true;
    }

    private void visit(List<List<Integer>> rooms, int index, int[] visited) {
        List<Integer> distinctKeys = rooms.get(index);
        visited[index]=1;
        for(int key : distinctKeys) {
            if(visited[key]==0) {
                visit(rooms, key, visited);
            }
        }

    }
}
