package BitManipulation;


public class ConverToDecimal {

    //incorrect
    public static int getDecimalValue(int num) {
        if(num==0)
            return 0;
        int value=0;
        while(num != 0)
        {
            int rightMostBitIsolated = num & (-num);
            value=(value<<1)+ rightMostBitIsolated;
            //drop the right most bit
            num >>>= 1;
        }
        return value;
    }
    public static void main(String[] args) {
        System.out.print(getDecimalValue(5));
    }
}
