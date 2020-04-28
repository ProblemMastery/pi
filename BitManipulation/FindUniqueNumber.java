package BitManipulation;

public class FindUniqueNumber {

    public static int[] singleNumber(int[] nums) {
        // difference between two numbers (x and y) which were seen only once
        int bitmask = 0;
        for (int num : nums)
             bitmask ^= num;

        // rightmost 1-bit diff between x and y
        int diff = bitmask & (-bitmask);

        int x = 0;
        // bitmask which will contain only x
        for (int num : nums)
            if ((num & diff) != 0)
                x ^= num;

        return new int[]{x, bitmask^x};
    }

    public static int counBits(int x){
        int numBits = 0;
        while(x!= 0){
            numBits += (x&1);
            x >>>= 1;
        }
        return numBits;
    }

    public static void main(String[] args) {
        int [] num = {1,2,3,1,2,4};
        //int [] res = singleNumber(num);
        System.out.print(counBits(3));
        //System.out.print(res);

    }
}
