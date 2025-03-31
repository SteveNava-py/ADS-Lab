package Threads;

public class TestingThreads {
    public static void main(String[] args) {
        /* Threads.MyThread t1 = new Threads.MyThread("thread a");
        Threads.MyThread t2 = new Threads.MyThread("thread b");
        Threads.MyThread t3 = new Threads.MyThread("thread c");
        t1.start();
        t2.start();
        t3.start();

        for(int i = 0; i < 20; i++) {
            Threads.MyThread T1 = new Threads.MyThread("Thread" + i);
            T1.start();
        } */

        GreetProdThread g1 = new GreetProdThread("thread a", "kumusta");
        GreetProdThread g2 = new GreetProdThread("thread b", "privet");
        GreetProdThread g3 = new GreetProdThread("thread c", "an-young hae-sae-yo");
        GreetProdThread g4 = new GreetProdThread("thread d", "xin chao");
        Thread t1 = new Thread(g1);
        Thread t2 = new Thread(g2);
        Thread t3 = new Thread(g3);
        Thread t4 = new Thread(g4);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
