package Threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MutualExclusion {

    public static void main(String args[]) throws InterruptedException {
        System.out.println("Shopper threads started and counting items");
        Thread shopperBar = new ShopperThreadWithLock();
        Thread shopperOli = new ShopperThreadWithLock();
        shopperBar.start();
        shopperOli.start();
        shopperBar.join();
        shopperOli.join();
        System.out.print("We should buy "+ShopperThreadWithLock.itemCount+" items");

    }
}
// the data race in the DataRace file is fixed.
class ShopperThreadWithLock extends Thread {

    static int itemCount = 0;
    static Lock pencilAsLock = new ReentrantLock();
    public void run() {
        System.out.println("Shopper thread has started and started to help out/work, it firts locks");
        pencilAsLock.lock();
        for (int i = 0 ; i < 1000000; i++) // try with 100, 1000
            itemCount++;
        pencilAsLock.unlock();
    }
}
/** output
 * Shopper threads started and counting itemsShopper thread has started and started to help out/work
 * Shopper thread has started and started to help out/work
 * We should buy 1526353 items
 */
