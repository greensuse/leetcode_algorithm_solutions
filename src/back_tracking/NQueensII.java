package back_tracking;

import java.util.LinkedList;
import java.util.List;

public class NQueensII {
    public static List<List<String>> solveNQueens(int n) {
        char[][] board=new char[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                board[i][j]='.';
            }
        }
        List<List<String>> res=new LinkedList<List<String>>();
        dfs(0, board, res);
        return res;
    }

    static boolean validate(char[][] board, int row, int col) {
        int duprow=row;
        int dupcol=col;
        //top-left
        while(row>=0 && col>=0) {
            if(board[row][col]=='Q') return false;
            row--; col--;
        }

        //left
        row=duprow;
        col=dupcol;
        while(col>=0) {
            if(board[row][col]=='Q') return false;
            col--;
        }
        //bottom-left
        row=duprow;
        col=dupcol;
        int n= board.length;
        while(col>=0 && row<n) {
            if(board[row][col]=='Q') return false;
            row++;col--;
        }
        return true;
    }

    static List<String> construct(char[][] board) {
        List<String> res = new LinkedList<String>();
        for(int i=0; i<board.length; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }

    static void dfs(int col, char[][] board, List<List<String>> res) {
        if(col==board.length) {
            res.add(construct(board));
            return;
        }
        for(int i=0; i<board.length; i++) {
            if(validate(board, i, col)) {
                board[i][col]='Q';
                dfs(col+1, board, res);
                board[i][col]='.';
            }
        }
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
