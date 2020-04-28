package My_Array;
/* done upload

238. Product of Array Except Self
Leetcode - https://leetcode.com/problems/product-of-array-except-self/
Given an array nums of n integers where n > 1,
return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Input:  [1,2,3,4]
Output: [24,12,8,6]

Soln : https://www.youtube.com/watch?v=khTiTSZ5QZY
 */
public class ProductOfArrayExcept {


    //sub optimal solution : calc left product, cal rt product for i, and multiply them

    public int [] subOptimal_productExceptSelf(int[] nums){
        if (nums.length ==0){
            return nums;
        }
        int N = nums.length;
        int [] outputArr = new int[N];


        int [] leftproduct = new int[N];
        int [] rtproduct = new int [N];

        leftproduct[0] = 1;
        rtproduct[N-1] = 1;

        for (int i = 1 ; i < N ; i++){
            leftproduct[i] = leftproduct[i-1] * nums[i-1];
        }

        for (int i = N-2; i >0 ; i--){
            rtproduct[i] = rtproduct[i+1] * nums[i+1];
        }

        for (int i = 0; i < N ; i ++)
            outputArr[i] = leftproduct[i] * rtproduct[i];

        return outputArr;
    }

    // optimal solution here we use the output arr to store left product and rt product is cal on fly using a var.

    public int[] productExceptSelf(int[] nums) {

        if (nums.length ==0){
            return nums;
        }
        int N = nums.length;
        int [] outputArr = new int[N];

        outputArr[0] = 1;

        // calc the left product
        for (int i = 1 ; i < N ; i++ ){
            outputArr[i] = outputArr[i-1]*nums[i];
        }

        // initialize rt product to be 1 first,
        // we keep multiplying it in every iteration with nums[i]
        int RtProduct = 1;

        for (int i = N-1 ; i>0 ; i--){
            outputArr[i] = outputArr[i] * RtProduct;

            RtProduct = RtProduct * nums[i];
        }

        return outputArr;
    }

}
