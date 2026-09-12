Design underground system:
import java.util.*;

class UndergroundSystem {

    class CheckIn {
        String station;
        int time;

        CheckIn(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    class Travel {
        double totalTime;
        int count;

        Travel() {
            totalTime = 0;
            count = 0;
        }
    }

    HashMap<Integer, CheckIn> checkIns;
    HashMap<String, Travel> trips;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        trips = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckIn(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckIn checkIn = checkIns.get(id);

        String key = checkIn.station + "#" + stationName;
        double travelTime = t - checkIn.time;

        if (!trips.containsKey(key)) {
            trips.put(key, new Travel());
        }

        Travel travel = trips.get(key);
        travel.totalTime += travelTime;
        travel.count++;

        checkIns.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "#" + endStation;
        Travel travel = trips.get(key);

        return travel.totalTime / travel.count;
    }
}
OUTPUT:
Input
["UndergroundSystem","checkIn","checkIn","checkIn","checkOut","checkOut","checkOut","getAverageTime","getAverageTime","checkIn","getAverageTime","checkOut","getAverageTime"]
[[],[45,"Leyton",3],[32,"Paradise",8],[27,"Leyton",10],[45,"Waterloo",15],[27,"Waterloo",20],[32,"Cambridge",22],["Paradise","Cambridge"],["Leyton","Waterloo"],[10,"Leyton",24],["Leyton","Waterloo"],[10,"Waterloo",38],["Leyton","Waterloo"]]
Output
[null,null,null,null,null,null,null,14.00000,11.00000,null,11.00000,null,12.00000]
Expected
[null,null,null,null,null,null,null,14.00000,11.00000,null,11.00000,null,12.00000]
