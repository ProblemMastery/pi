package My_Array;

public class Hard_FirstMissingPositive {



   public int findFirstMissingPositive(int [] nums){

       //check if it contains 1
       boolean containsOne = false;
       for (int n : nums){
           if (n  == 1) {
               containsOne = true;
               break;
           }
       }
       if (!containsOne)
           return 1;
       //change all the numbers greater than 1 and numbers greater than nums size to 1;
       int N = nums.length;
       for (int i = 0 ; i < N; i++){
           if (nums[i] <= 0 || nums[i] > N){
               nums [i] = 1;
           }
       }
       for (int i = 0; i < N ; i++){
           int a = Math.abs(nums[i]);

           if (a == N){
               nums[0] = - Math.abs(nums[0]);
           }else
               nums[a] = - Math.abs(nums[a]);
       }
       for (int i = 1 ; i < N ; i++){
           if (nums[i] > 0)
               return i;
       }

       //if all the numbers from 1 to N-1 is positive then if 0th index is positive
       // return the size, i.e N
       if (nums [0] > 0)
           return N;
       // else the first Missing positive in N+1;
       return N+1;
   }
}
