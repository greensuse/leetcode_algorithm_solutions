package back_tracking;

import java.util.LinkedList;
import java.util.List;

public class NQueensII_II {
    public static List<List<String>> solveNQueens(int n) {
        char[][] board=new char[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                board[i][j]='.';
            }
        }
        List<List<String>> res=new LinkedList<List<String>>();
        int leftRow[]=new int[n];
        int lowerDiagonal[] = new int[2*n-1];
        int upperDiagonal[] = new int[2*n-1];
        dfs(0, board, res, leftRow, lowerDiagonal, upperDiagonal);
        return res;
    }


    static void dfs(int col, char[][] board, List<List<String>> res, int leftRow[], int lowerDiagonal[], int upperDiagonal[]) {
        if(col==board.length) {
            res.add(construct(board));
            return;
        }
        for(int row=0; row<board.length; row++) {
            if(leftRow[row]==0 && lowerDiagonal[row+col]==0 && upperDiagonal[board.length-1+col-row]==0) {
                board[row][col]='Q';
                leftRow[row]=1;
                lowerDiagonal[row+col]=1;
                upperDiagonal[board.length-1+col-row]=1;
                dfs(col+1, board, res, leftRow, lowerDiagonal, upperDiagonal);
                board[row][col]='.';
                leftRow[row]=0;
                lowerDiagonal[row+col]=0;
                upperDiagonal[board.length-1+col-row]=0;
            }
        }
    }

    static List<String> construct(char[][] board) {
        List<String> res = new LinkedList<String>();
        for(int i=0; i<board.length; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }

    public static void main(String[] args) {
        int n=4;
        List<List<String>> res=solveNQueens(n);
        int i=1;
        for(List<String> it : res) {
            System.out.println("Arrangement " + i);
            for(String s : it) {
                System.out.println(s);
            }
            System.out.println();
            i+=1;
        }
    }
}
