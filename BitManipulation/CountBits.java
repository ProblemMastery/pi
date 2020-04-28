package BitManipulation;

public class CountBits {

    public static int parity(int x) {
        int result = 0;
        while (x != 0) {
            result ^= 1;
            // clang-format off
            x &= (x-1);
            // clang-format on
    }
        return result;
    }

    public static int numBits(int x) {
        int numBits = 0;
        while (x != 0) {
           numBits += (x&1);
           x >>>=1;
        }
        return numBits;
    }

    // parity is number of even bits
    public static short parity2(long x) {
        x ^= x >>> 32;
        x ^= x >>> 16;
        x ^= x >>> 8;
        x ^= x >>> 4;
        x ^= x >>> 2;
        x ^= x >>> 1;
        return (short)(x & 0x1);
    }
    public static void main(String[] args) {
        //int [] res = singleNumber(num);
        System.out.print(numBits(7));
        //System.out.print(res);

    }
}
