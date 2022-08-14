package recursion_i;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
    public static void main(String[] args) {
        List<Integer> ans=new PascalsTriangleII().getRow(3);
        System.out.println(ans);
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> row=new ArrayList<>();
        for(int i=0; i<=rowIndex; i++) {
            row.add(0, 1);
            for(int j=1; j<row.size()-1; j++) {
                row.set(j, row.get(j)+row.get(j+1));
            }
        }
        return row;
    }
}
