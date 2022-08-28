package design;

import java.util.LinkedList;
import java.util.List;

public class OrderedStream {
    private final String[] stream;
    private int offset=0;
    public OrderedStream(int n) {
        stream=new String[n];
    }

    public List<String> insert(int idKey, String value) {
        stream[idKey-1]=value;
        List<String> res=new LinkedList<>();
        while(offset<this.stream.length && stream[offset]!=null) {
            res.add(stream[offset++]);
        }
        return res;
    }
}
