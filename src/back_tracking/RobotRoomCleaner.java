package back_tracking;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class RobotRoomCleaner {
    //Up, Right, Down, Left
    final int[][] DIRECTIONS={{-1,0},{0,1},{1,0},{0,-1}};
    Set<String> visited=new HashSet<>();

    public void cleanRoom(Robot robot) {
        dfs(0,0, robot, 0);
    }

    private void dfs(int row, int col, Robot robot, int arrow) {
        String key=row+","+col;
        if(!visited.contains(key)) {
            visited.add(key);
            robot.clean();
            for(int i=0; i<4; i++) {
                if(robot.move()) {
                    int[] curDirection = DIRECTIONS[arrow];
                    dfs(row+curDirection[0], col+curDirection[1], robot, arrow);
                }
                robot.turnRight();
                arrow=(arrow+1)%4;
            }
        }
        //Move Back
        moveBack(robot);
    }

    private void moveBack(Robot robot) {
        robot.turnLeft();
        robot.turnLeft();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}

interface Robot {
    // Returns true if the cell in front is open and robot moves into the cell.
    // Returns false if the cell in front is blocked and robot stays in the current cell.
    public boolean move();

    // Robot will stay in the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    public void turnLeft();
    public void turnRight();

    // Clean the current cell.
    public void clean();
}
