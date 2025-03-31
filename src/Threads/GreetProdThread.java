package Threads;

public class GreetProdThread implements Runnable{
    String greeting;
    String threadName;
    public static final int REPS = 10;
    public static final int DELAY = 10;

    public GreetProdThread(String tname, String greeting) {
        this.greeting = greeting;
        this.threadName = tname;
        System.out.println("Creating thread: " + this.threadName);
    }
    public void run(){
        System.out.println("Running: " + this.threadName);
        try {
            for (int i = 0; i < REPS; i++) {
                System.out.println("Executing: " + this.threadName + " " + i + ": " + greeting);
                Thread.sleep(DELAY);
            }
        } catch(InterruptedException ex) {
            System.out.println("Interrupting Thread: " + this.threadName);
        }
        System.out.println("Exiting Thread: " + this.threadName);
    }
}
