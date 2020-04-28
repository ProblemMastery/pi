package Math;
/*
On an infinite plane, a robot initially stands at (0, 0) and faces north.
 The robot can receive one of three instructions:

"G": go straight 1 unit;
"L": turn 90 degrees to the left;
"R": turn 90 degress to the right.
The robot performs the instructions given in order, and repeats them forever.

Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.



Example 1:

Input: "GGLLGG"
Output: true
Explanation:
The robot moves from (0,0) to (0,2), turns 180 degrees, and then returns to (0,0).
When repeating these instructions, the robot remains in the circle of radius 2 centered at the origin.
 */
public class RobotBoundedInCircle {

    public boolean isRobotBounded(String ins) {

        int x = 0 , y = 0;
        int dir = 0 ; // 0 : north, 1: right, 2: down, 3: left
        int[][] directions = new int [][]{{0,1}, {1,0}, {0,-1}, {-1, 0}};

        for (char c : ins.toCharArray()){

            if (c == 'G'){
                x = x+ directions[dir][0];
                y = y+ directions[dir][1];
            }else if (c == 'L'){
                dir = (dir + 3)%4;
            }else
                dir = (dir + 1)%4 ;
        }
            if (x == 0 && y == 0) {
                // ended in same place
                return true;
            }
            if (dir == 0 && (x!= 0 && y != 0)){
                // if the direction is north and location has changed
                return false;
            }
            return true;
    }
}
