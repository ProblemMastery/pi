

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DrawingSkylines {
    // @include
    public static class Rectangle {
        public int left, right, height;

        public Rectangle(int left, int right, int height) {
            this.left = left;
            this.right = right;
            this.height = height;
        }

        public String toString(){
            StringBuilder sb = new StringBuilder();
            return sb.append(left+",").append(right+",").append(height+"").toString();
        }
    }

    public static List<Rectangle> drawingSkylines(List<Rectangle> buildings) {
        int minLeft = Integer.MAX_VALUE, maxRight = Integer.MIN_VALUE;
        for (Rectangle building : buildings) {
            minLeft = Math.min(minLeft, building.left);
            maxRight = Math.max(maxRight, building.right);
        }

        List<Integer> heights
                = new ArrayList<>(Collections.nCopies(maxRight - minLeft + 1, 0));
        for (Rectangle building : buildings) {
            for (int i = building.left; i <= building.right; ++i) {
                heights.set(i - minLeft,
                        Math.max(heights.get(i - minLeft), building.height));
            }
        }

        List<Rectangle> result = new ArrayList<>();
        int left = 0;
        for (int i = 1; i < heights.size(); ++i) {
            if (heights.get(i) != heights.get(i - 1)) {
                result.add(
                        new Rectangle(left + minLeft, i - 1 + minLeft, heights.get(i - 1)));
                left = i;
            }
        }
        result.add(new Rectangle(left + minLeft, maxRight,
                heights.get(heights.size() - 1)));
        return result;
    }
    // @exclude

    private static void checkAnswer(List<Rectangle> ans) {
        // Just check there is no overlap.
        for (int i = 0; i < ans.size(); ++i) {
            assert(ans.get(i).left <= ans.get(i).right);
            if (i > 0) {
                assert(ans.get(i - 1).right <= ans.get(i).left);
                assert(ans.get(i - 1).right != ans.get(i).left
                        || ans.get(i - 1).height != ans.get(i).height);
            }
        }
    }

    public static void main(String[] args) {
        int [][] buildings = new int [][] {{2,9,10}, {3 ,7, 15}, {5,12,12}, {15,20,10}, {19,24,8}};
        List<Rectangle> A = new ArrayList<>();
            for (int i = 0; i < buildings.length; ++i) {
                int left = buildings[i][0];
                int right = buildings[i][1];
                int height =buildings[i][2];
                A.add(new Rectangle(left, right, height));
            }
            List<Rectangle> ans = drawingSkylines(A);
            System.out.println(ans);
            checkAnswer(ans);
        }
    }