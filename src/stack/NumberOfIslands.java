package stack;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = {{'1','1','1'},{'0','1','0'},{'1','1','1'}};
        int res = numIslands(grid);
        System.out.println(res);
    }
    public static int numIslands(char[][] grid) {
        int numOfIsland=0;

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j]=='1') {
                    numOfIsland+=1;
                    dfs(i,j,grid);
                }
            }
        }

        return numOfIsland;
    }

    private static void dfs(int i, int j, char[][] grid) {
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]=='0') {
            return;
        }

        grid[i][j]='0';

        dfs(i+1, j, grid);
        dfs(i-1, j, grid);
        dfs(i, j+1, grid);
        dfs(i, j-1, grid);


    }
}
