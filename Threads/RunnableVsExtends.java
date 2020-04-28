package Threads;

public class RunnableVsExtends {
    /**
     * Extends                                  Runnable
     * Cannot extend additional classes       can implement other class and extend other class
     * Each instance is a separate Object     Multiple threads can share a single Runnable object
     */
    public static void main(String args[]) throws InterruptedException {
        System.out.print("Main thread started and requesting a helperThread for help");
        Thread helper = new HelperThread_1();
        Thread helper2 = new Thread(new HelperThread_2()); // runnable object inside

        System.out.println("Main thread calls helper thread to start");
        helper.start();


        System.out.println("Main thread does the remaining work");
        Thread.sleep(500);


        System.out.println("Main thread waits for helper to complete its work and join");
        helper.join(); // main threads wait until helper completes

        System.out.print("Main and helper are done");
    }
}
class HelperThread_1 extends Thread {

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

class HelperThread_2 implements Runnable {

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
