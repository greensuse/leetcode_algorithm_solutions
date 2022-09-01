package design;

import java.util.*;

public class Leaderboard {
    Map<Integer, Integer> map=new HashMap<>();
    public Leaderboard() {

    }

    public void addScore(int playerId, int score) {
        map.put(playerId, map.getOrDefault(playerId, 0)+score);
    }

    public int top(int K) {
        List<Integer> values = new ArrayList<Integer>(map.values());
        Collections.sort(values, Collections.reverseOrder());
        int sum = values.stream().limit(K).reduce(0, (a,b)->a+b);
        return sum;
    }

    public void reset(int playerId) {
        map.put(playerId, 0);
    }
}
