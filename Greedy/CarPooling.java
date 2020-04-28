package Greedy;

import java.util.*;

public class CarPooling {

        private static class Trip implements Comparable<Trip>{
            int passenger;
            int startLocation;
            int endLocation;
            public Trip(int p, int s, int end){
                this.passenger = p;
                this.startLocation = s;
                this.endLocation = end;
            }
            public int compareTo(Trip t){
                if ( this.startLocation > t.startLocation ) return  1;
                if (this.startLocation < t.startLocation) return -1;
                else return 0;
            }

            public boolean doesOverLap(Trip b){
                return this.startLocation < b.endLocation && this.endLocation > b.startLocation;
            }

        }
        public static boolean carPooling(int[][] trips, int capacity) {
            Map<Integer, Integer> dropOffMap = new HashMap<>();
            List<Trip> tripList = new ArrayList<>();
            for (int i = 0 ; i <trips.length; i++){
                Trip t = new Trip(trips[i][0], trips[i][1], trips[i][2]);
                dropOffMap.put(trips[i][2],dropOffMap.getOrDefault(trips[i][2], 0)+trips[i][0] );
                tripList.add(t);
            }

            Collections.sort(tripList);
            int currentSize = tripList.get(0).passenger;
            for ( int i = 1; i < tripList.size(); i++){
                    currentSize += tripList.get(i).passenger;
                    int unloadAtThisPoint = getNoOfPassengersUnloaded(dropOffMap, tripList.get(i));
                    currentSize = currentSize - unloadAtThisPoint;
                    if(currentSize > capacity)
                        return false;
                }
            return true;
            }

    private static int getNoOfPassengersUnloaded(Map<Integer, Integer> dropOffMap, Trip trip) {

            int currentPoint = trip.startLocation;
            int noofPassengerDropped = 0;
            for(Map.Entry<Integer, Integer>
                    entry : dropOffMap.entrySet()){
                int k = entry.getKey();
                if(k <= currentPoint){
                    noofPassengerDropped += dropOffMap.get(k);
                    dropOffMap.put(k, 0);
                }
            }
            return noofPassengerDropped;
        }

        public static void main(String [] args){
            int[][] trips = {{2,1,5},{3,5,7}};

            System.out.print(carPooling(trips, 28));
        }
}
