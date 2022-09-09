package other;

public class RateLimiter_TokenBucket {
    long ts = 0;
    int token=4;

    boolean f(long timestamp) {
        if(timestamp-ts>6_000_000) {
            token=4;
            ts=timestamp;
            return true;
        } else {
            token--;
            if(token>0) return true;
            return false;
        }

    }
}



