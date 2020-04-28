package My_Array;

public class CanPlaceFlowers {
    /*
    Suppose you have a long flowerbed in which some of the plots are planted and some are not.
    However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.
    Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty),
     and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.

     Input: flowerbed = [1,0,0,0,1], n = 1
     Output: True
     */
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {

        if(flowerbed.length == 0){
            return false;
        }


        int i =0;
        while(i < flowerbed.length){

            // check the key conditiond, i.e the current should be 0, for position i i+1 and i-1 should be 0
            if(flowerbed[i]== 0 && (i == 0 || flowerbed[i-1]==0)&& (i==flowerbed.length|| flowerbed[i+1]==0)){
                if (n != 0 ){
                    n--;
                    flowerbed[i]=1;
                }
            }
        }
        return n==0;
    }

    private static int getNbrs(int[] flowerbed, int i){

        if( i == 0 && flowerbed.length > 1){
            return flowerbed[i+1];
        }else  if(i == flowerbed.length-1){
            return flowerbed[i-1];
        }else{
            return flowerbed[i-1]+ flowerbed[i+1];
        }

    }

    public static void main(String []args){
        int[] bed = new int[] {0};
        System.out.println(canPlaceFlowers(bed,2));
    }

}
