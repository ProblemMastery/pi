package Threads;

public class DaemonThread {
    /**
     * sometimes when we spawn a new thread, called child thread the main thread cannot exit until the child completes.
     * eg : garbage Collection, such threads could be made as DaemonThreads
     * So A Daemon Thread - does not prevent the process from terminating
     * By default, threads are created as non-daemon
     * if daemon is doing any I/O operation like writing to a file , it could corrupt data.
     * a new thread created from daemon thread will also be a daemon thread
     * when JVM exits any daemon threads left, are abandoned.
     */
    public static void main(String args[]) throws InterruptedException {
        Thread helper = new HelperThread();
        helper.setDaemon(true); // if this is not present the process would never terminate
        helper.start();

        System.out.println("Main thread does the remaining work");
        Thread.sleep(500);
        System.out.println("Main thread still doing the remaining work");
        Thread.sleep(500);

        System.out.println("Main thread waits for helper to complete its work and join");

        System.out.print("Main and helper are done");
    }
}

class cleaner extends Thread {

    public void run(){
        while(true) {
            System.out.print("cleaner cleans");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}