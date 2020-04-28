package SortingAndSearching;

import javax.swing.*;

public class Hard_MedianTwoSortedArrays {


    public static double getMedianOfTwoSortedArrays(int[] nums1, int[] nums2) {
        //if input1 length is greater than switch them so that input1 is smaller than input2.
        if (nums1.length > nums2.length) {
            getMedianOfTwoSortedArrays(nums2, nums1);
        }

        int X = nums1.length;
        int Y = nums2.length;

        int start = 0;
        int end = X-1;

        while (start <= end) {

            int partitionX = (end + start) / 2;
            int partitionY = (X + Y + 1) / 2 - partitionX;

            //if partitionX is 0 it means nothing is there on left side. Use -INF for maxLeftX
            //if partitionX is length of input then there is nothing on right side. Use +INF for minRightX
            int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = partitionX == end ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = partitionY == (Y - 1) ? Integer.MAX_VALUE : nums2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {

                if ((X + Y) % 2 == 0) //
                    return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                else
                    return (double) Math.max(maxLeftX, maxLeftY);

            } else {
                if (maxLeftX > minRightY) {
                    // we are too much right on X, so decrease the window
                    end = partitionX - 1;
                } else
                    //we are too far on left side for partitionX. Go on right side.
                    start = partitionX + 1;
            }

        }
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        int[] x = {1, 3, 8, 9, 15};
        int[] y = {7, 11, 19, 21, 18, 25};

        System.out.print(getMedianOfTwoSortedArrays(x, y));
    }
}
