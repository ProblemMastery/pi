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
        System.out.print("Main thread started and requesting a helperThread for help");
        Thread helper = new HelperThread();
        System.out.println("Helper state :"+helper.getState());

        System.out.println("Main thread calls helper thread to start");
        helper.start();
        System.out.println("Helper state :"+helper.getState());


        System.out.println("Main thread does the remaining work");
        Thread.sleep(500);
        System.out.println("Helper state :"+helper.getState());


        System.out.println("Main thread waits for helper to complete its work and join");
        helper.join(); // main threads wait until helper completes
        System.out.println("Helper state :"+helper.getState());

        System.out.print("Main and helper are done");
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
