package queue;

public class NumberOfIslands_2 {

    public int numIslands(char[][] grid) {
        int numOfIsland=0;

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j]=='1') {
                    numOfIsland+=1;
                    bfs(i,j,grid);
                }
            }
        }

        return numOfIsland;
    }

    private void bfs(int i, int j, char[][] grid) {
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]=='0') {
            return;
        }

        grid[i][j]='0';

        bfs(i+1, j, grid);
        bfs(i-1, j, grid);
        bfs(i, j+1, grid);
        bfs(i, j-1, grid);
    }
}
