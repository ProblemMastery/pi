package Heap;

import java.util.*;
import java.util.stream.Collectors;

public class KCLosestPoints {
    /*We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
(Here, the distance between two points on a plane is the Euclidean distance.)
You may return the answer in any order.
The answer is guaranteed to be unique (except for the order that it is in.)

Time : O(NLogK)
Space O(k) because we need to store ‘K’ point in the heap

     */
    private static class Point implements Comparable<Point>{
        int x,y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        public double distance() {
            return Math.sqrt(x*x + y*y);
        }

        @Override
        public int compareTo(Point that){
            return Double.compare(this.distance(), that.distance());
        }
        public String toString(){
            StringBuilder sb = new StringBuilder();
            return  sb.append(this.x).append(",").append(this.y).toString();
        }
    }

    public static int[][] kClosest(int[][] points, int k) {

        Point origin = new Point(0,0);
        PriorityQueue<Point> maxHeap = new PriorityQueue<>((p1, p2)-> (int) (p2.distance() - p1.distance()));

        List<Point> pointList = new ArrayList<>();

        for (int i = 0 ; i < points.length; i++){
           Point p = new Point(points[i][0], points[i][1]);
            pointList.add(p);
        }
//
//        for(Point p : pointList)
//            maxHeap.add(p);
//            if (maxHeap.size() == k+1)
//                maxHeap.remove();
//        }
//
        for (int i = 0 ; i < k ; i++){
            maxHeap.add(pointList.get(i));
        }

        for (int i = k; i < pointList.size(); i++){
            if (pointList.get(i).compareTo(maxHeap.peek()) < 0){
                maxHeap.poll();
                maxHeap.add(pointList.get(i));
            }
        }


        int [][] result = new int [maxHeap.size()][2];

        int i = 0;
        Iterator<Point> itr = maxHeap.iterator();
        while (itr.hasNext()){
            Point p = itr.next();
            result[i][0] = p.x;
            result[i][1] = p.y;
            i++;

        }

        return result;
    }
    public static void main(String[] args) {
       int [][] points = new int [][]{{1, 3},{3,4},{2,-1}};

       int [][] res = kClosest(points, 2);

       for (int i = 0 ; i < res.length; i++){
           System.out.print("["+res[i][0]+","+res[i][1]+"]");
       }
        System.out.print(", ");
    }
}
