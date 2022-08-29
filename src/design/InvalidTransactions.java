package design;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class InvalidTransactions {
    public List<String> invalidTransactions(String[] transactions) {
        List<String> res=new LinkedList<>();
        Map<String, List<Transaction>> map=new HashMap<>();

        for(String s : transactions) {
            Transaction t = new Transaction(s);
            map.putIfAbsent(t.name, new LinkedList<Transaction>());
            map.get(t.name).add(t);
        }

        for(String s : transactions) {
            Transaction t = new Transaction(s);
            if(!isValid(t, map.get(t.name))) {
                res.add(s);
            }
        }

        return res;
    }

    private boolean isValid(Transaction t,  List<Transaction> txns) {
        if(t.amount>1000) {
            return false;
        }
        for(Transaction t2 : txns) {
            if(!t2.city.equals(t.city) && Math.abs(t2.time-t.time)<=60) {
               return false;
            }
        }
        return true;
    }

    class Transaction {
        String name, city;
        int time, amount;

        public Transaction(String s) {
            String[] segments = s.split(",");
            this.name=segments[0];
            this.time=Integer.valueOf(segments[1]);
            this.amount=Integer.valueOf(segments[2]);
            this.city=segments[3];
        }
    }
}
