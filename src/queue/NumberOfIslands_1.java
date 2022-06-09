package queue;

public class NumberOfIslands_1 {

    public int numIslands(char[][] grid) {
        int numOfIsland=0;

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j]=='1') {
                    numOfIsland+=dfs(i,j,grid);
                }
            }
        }

        return numOfIsland;
    }

    private int dfs(int i, int j, char[][] grid) {
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]=='0') {
            return 0;
        }

        if(i<grid.length-1 && grid[i+1][j]=='1') {
            grid[i+1][j]=0;
            dfs(i+1, j, grid);
        }
        if(i>0 && grid[i-1][j]=='1') {
            grid[i-1][j]=0;
            dfs(i-1, j, grid);
        }
        if(j<grid[0].length-1 && grid[i][j+1]=='1') {
            grid[i][j+1]=0;
            dfs(i, j+1, grid);
        }
        if(j>0 && grid[i][j-1]=='1') {
            grid[i][j-1]=0;
            dfs(i, j-1, grid);
        }

        return 1;
    }
}
