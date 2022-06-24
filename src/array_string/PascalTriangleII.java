package array_string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangleII {
     public List<Integer> getRow(int rowIndex) {
        List<Integer> result=new ArrayList<>();
        for(int i=0; i<=rowIndex; i++) result.add(1);
        for(int i=1; i<rowIndex; i++) {
            for(int j=i; j>0; j--) {
                result.set(j, result.get(j)+result.get(j-1));
            }
        }
        return result;
    }
}
