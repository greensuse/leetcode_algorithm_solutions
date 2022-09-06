package map;

import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {
    Map<String, Integer> map=null;

    public LoggerRateLimiter() {
        map=new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if(map.get(message)==null) {
            map.put(message, timestamp);
            return true;
        }

        int old_timestamp = map.get(message);
        if(timestamp-old_timestamp>=10) {
            map.put(message, timestamp);
            return true;
        }

        return false;
    }
}
