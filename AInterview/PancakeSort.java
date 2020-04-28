package AInterview;

public class PancakeSort {


        static int[] pancakeSort(int[] arr) {
            // your code goes here
            int n = arr.length;

            for(int size = n ; size >1; size--){

                int indexMax = getMaxIndex(arr, size);

                if(indexMax != size-1){
                    flip(arr, indexMax);

                    flip(arr, size-1);
                }
            }
            return arr;
        }

        static int getMaxIndex(int [] arr, int n){
            int index=0;
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < n; i++){
                if(arr[i] > max ){
                    max  = arr[i];
                    index = i;
                }
            }
            return index;
        }



        static void flip (int[] arr, int k){

            for (int i = 0 ; i < k; i++){
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
                k--;
            }
        }

        public static void main(String[] args) {

            int [] arr = {1, 5, 4, 3, 2};

            int [] result = pancakeSort(arr);

            for(int i: result){
                System.out.print(i);
            }
        }

    }


