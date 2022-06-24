package array_string;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle_3 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList<>();
        if(numRows==0) return res;

        List<Integer> firstRow=new ArrayList<>();
        firstRow.add(1);
        res.add(firstRow);

        for(int i=1; i<numRows; i++) {
            List<Integer> row=new ArrayList<Integer>(i+1);
            row.add(1);
            for(int j=1; j<i; j++) {
                row.add(res.get(i-1).get(j)+res.get(i-1).get(j-1));
            }
            row.add(1);
            res.add(row);
        }

        return res;

    }
}
