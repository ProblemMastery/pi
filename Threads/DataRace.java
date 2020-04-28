package Threads;

public class DataRace {
    /**
     * 2 concurrent threads
     * lets say one thread is looking into recipe to get new grocery and the other simply modifies the shopping list
     * Thread A, sees there are 2 potatoes, it needs 3 more , so modifies the shopping list to 5
     * Thread B  now sees there are only 10 of x items, and it needs to 2 more,
     * meanwhile A sees there are only 10 of x items it needs 8 more of thm, adds and write the value as 18.
     * now threadB finishes the calsulation and add 10+2,modifies 18 as 12.
     */
    public static void main(String args[]) throws InterruptedException {
        System.out.print("Shopper threads started and counting items");
        Thread shopperA = new ShopperThread();
        Thread shopperB = new ShopperThread();
        shopperA.start();
        shopperB.start();
        shopperA.join();
        shopperB.join();
        System.out.print("We should buy "+ShopperThread.itemCount+" items");

    }
}
    class ShopperThread extends Thread {

        static int itemCount = 0;
        public void run() {
            System.out.println("Shopper thread has started and started to help out/work");


            for (int i = 0 ; i < 1000000; i++) // try with 100, 1000
                itemCount++;
        }
    }
/** output
 * Shopper threads started and counting itemsShopper thread has started and started to help out/work
 * Shopper thread has started and started to help out/work
 * We should buy 1526353 items
 */
