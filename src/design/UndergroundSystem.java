package design;

import java.util.HashMap;
import java.util.Map;

public class UndergroundSystem {
    Map<Integer, CheckInData> checkInDataMap=new HashMap<>();
    Map<String, JourneyData> journeyDataMap=new HashMap<>();

    public UndergroundSystem() {

    }

    public void checkIn(int id, String stationName, int t) {
        checkInDataMap.put(id, new CheckInData(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckInData checkInData=checkInDataMap.get(id);
        int journeyTime=t-checkInData.checkInTime;
        JourneyData journeyData = journeyDataMap.getOrDefault(checkInData.startStation+"->"+stationName, new JourneyData(0,0));
        journeyData.total+=journeyTime;
        journeyData.count+=1;

        journeyDataMap.put(checkInData.startStation+"->"+stationName, journeyData);

        checkInDataMap.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        JourneyData journeyData = journeyDataMap.get(startStation+"->"+endStation);
        return journeyData.total*1.0d/journeyData.count;
    }

    class CheckInData {
        String startStation;
        int checkInTime;

        CheckInData(String startStation, int checkInTime) {
            this.startStation=startStation;
            this.checkInTime=checkInTime;
        }
    }

    class JourneyData {
        int total, count;
        JourneyData(int total, int count) {
            this.total=total;
            this.count=count;
        }
    }
}
