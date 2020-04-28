package StacksAndQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MovingAverages {
    /*
    Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

    Example:

        MovingAverage m = new MovingAverage(3);
        m.next(1) = 1
        m.next(10) = (1 + 10) / 2
        m.next(3) = (1 + 10 + 3) / 3
        m.next(5) = (10 + 3 + 5) / 3
     */

    private List<Integer> streamQ;
    int size;

    public MovingAverages (){
        this.size = size;
        streamQ = new ArrayList<Integer>();
    }

    public double next(int val){
        streamQ.add(val);

        int sum =0;
        for(int i = Math.max(0, streamQ.size()-size); i < streamQ.size(); i++){
            sum += streamQ.get(i);
        }
        return sum/(Math.min(streamQ.size(), size));
    }

}
