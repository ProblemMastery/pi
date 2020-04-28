package AInterview;

public class GettingDifferentNumber {
    /*
    Getting a Different Number
    Given an array arr of unique nonnegative integers,
    implement a function getDifferentNumber that
    finds the smallest nonnegative integer that is NOT in the array.
    eg :  input:  arr = [0, 1, 2, 3]
          output: 4
     */

    static int getDifferentNumber(int[] arr) {
        int n = arr.length;
        int temp;

        for ( int i = 0 ; i < n-1; i++){
            temp = arr[i];
            while (temp < n && arr[temp] != temp){

                int k = temp;
                temp = arr[temp];
                arr[temp] = k;
            }
        }

        for (int j =0 ; j < n-1; j++){
            if(arr[j]!= j)
                return j;
        }

        return n;

    }

    public static void main(String[] args) {

        int [] arr = {1,3,2,0};

        System.out.println(getDifferentNumber(arr));
    }
}
