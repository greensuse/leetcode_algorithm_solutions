package map;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set=new HashSet<>();
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                char c=board[i][j];
                if(c!='.') {
                    boolean rowOk=set.add(c+" found in row " + i);
                    boolean colOk=set.add(c+" found in column " + j);
                    boolean blockOk=set.add(c+" found in block " + i/3+" "+j/3);

                    if (!rowOk || !colOk || !blockOk) {
                        return false;
                    };
                }

            }
        }

        return true;
    }
}
