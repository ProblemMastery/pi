package Math;

public class SquareRoot {


    /*
    Implement int sqrt(int x).
    Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
    Since the return type is an integer, the decimal digits are truncated and
    only the INTEGER part of the result is returned.
     */

    /*
    Algorithm : Sqrt of x is always less than x/2; and greater than 2
    now the problem goes down to searching for a number between 2 to x/2;
    WE can use binary search,
    as we calculate the mid/pivot element, we find out if the square of mid/pivot is greater than or less than x.
    if greater, means pivot is smaller than the searching number, so reduce the window size i.e
      elements on right side of pivot are not in searching window right = pivot-1
    if smaller, means pivot is greater than searching number, the number should be greater than pivot, means all the
     elements on left side of pivot are not in searching window, so left = pivot+1;
     */
    public int mySqrt(int x) {

        if( x == 1 ){
            return x;
        }
        if (x ==2 || x ==3)
            return 1;

        int left = 2;
        int right = x/2;

        while(left <= right){
            int pivot = left + (right - left)/2;
            int num = pivot * pivot;

            if(num > x) {
                // means the sqrt of x is less than pivot,
                //so all the elements greater than pivot are not the candidates, so reduce the search window on right
                right = pivot - 1;
            }else if (num < x){
                // means the sqrt of x is greater than pivot
                //so all the elements less than pivot are not candidates, so increase left pointer.
                left = pivot+1;
            }else
                return pivot;
        }
        return right;
    }
}
