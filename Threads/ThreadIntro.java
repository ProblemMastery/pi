package Threads;

public class ThreadIntro {

    /**
     * States :
     * NEW
     * RUNNABLE
     * BLOCKED
     * WAITING
     * TIMED_WAITING
     * TERMINATED
     * Code demonstrating lifecycle
     */

    public static void main(String args[]) throws InterruptedException {
        System.out.println("1.Main thread started and requesting a helperThread for help");
        Thread helper = new HelperThread();
        System.out.println("2.Helper state :"+helper.getState()); // NEW

        System.out.println("Main thread calls helper thread to start");
        helper.start();
        System.out.println("3. Helper state :"+helper.getState()); // RUNNABLE


        System.out.println("4.Main thread does the remaining work");
        Thread.sleep(500);
        System.out.println("5.Helper state :"+helper.getState()); //TIMED_WAITING


        System.out.println("6.Main thread waits for helper to complete its work and join");
        helper.join(); // main threads wait until helper completes
        System.out.println("7.Helper state :"+helper.getState()); //TERMINATED

        System.out.print("8.Main and helper are done");
    }

}
class HelperThread extends Thread {

    public void run() {
        System.out.println("Helper thread has started and started to help out/work");
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Helper thread has completed its work");
    }
}
