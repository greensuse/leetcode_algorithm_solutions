package array_string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList<>();
        if(numRows==1) {
            List<Integer> row1=Arrays.asList(new Integer[]{1});
            res.add(row1);
        } else if(numRows==2) {
            List<Integer> row1=Arrays.asList(new Integer[]{1});
            res.add(row1);
            List<Integer> row2=Arrays.asList(new Integer[]{1,1});
            res.add(row2);
        } else {
            List<Integer> row1=Arrays.asList(new Integer[]{1});
            res.add(row1);
            List<Integer> row2= Arrays.asList(new Integer[]{1,1});
            res.add(row2);

            for(int row=3; row<=numRows; row++) {
                LinkedList<Integer> newRow=new LinkedList<Integer>();
                List<Integer> lastRow=res.get(row-2);
                newRow.add(1);
                for(int i=0; i<lastRow.size()-1; i++) {
                    newRow.add(lastRow.get(i)+lastRow.get(i+1));
                }
                newRow.add(1);
                res.add(newRow);
            }
        }

        return res;

    }
}
