package SlidingWindow;

public class ReplacingOnes {



        public static int findLength(int[] arr, int k) {
            int start = 0 ;
            int ZeroCountInWin = 0;
            int maxLen = 0;
            for (int end = 0 ; end < arr.length; end++){

                if (arr[end] == 0)
                    ZeroCountInWin++;

                if (ZeroCountInWin > k){
                    if (arr[start] ==  0)
                        ZeroCountInWin--;

                    start++;
                }
                maxLen = Math.max(maxLen, end-start+1);
            }
            return maxLen;
        }
    public static void main(String[] args) {
        System.out.println(ReplacingOnes.findLength(new int[] { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 }, 2));
        System.out.println(ReplacingOnes.findLength(new int[] { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 }, 3));
    }
}
