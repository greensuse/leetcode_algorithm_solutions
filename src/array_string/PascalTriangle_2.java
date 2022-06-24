package array_string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PascalTriangle_2 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> row, pre=null;

        for(int i=0; i<numRows; i++) {
            row=new ArrayList<Integer>(i+1);
            for(int j=0; j<=i; j++) {
                if(j==0 || j==i) {
                    row.add(1);
                } else {
                    row.add(pre.get(j)+pre.get(j-1));
                }
            }
            pre=row;
            res.add(row);

        }

        return res;
    }
}
