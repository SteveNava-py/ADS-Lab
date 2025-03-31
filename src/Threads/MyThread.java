package Threads;

public class MyThread extends Thread {
    String threadName;

    public MyThread(String name) {
        this.threadName = name;
    }

    public void run() {
        setName(this.threadName);
        System.out.println("Thread being executed: " + this.threadName);
        try {
            Thread.sleep(10000);
            System.out.println("Still executing thread... : " + this.threadName);
        }
        catch(InterruptedException e) {
            System.out.println("ERROR. Thread: " + this.threadName + " was interrupted");
        }
    }
}
