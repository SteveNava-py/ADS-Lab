package RaceCond;

import java.util.ArrayList;
import java.util.List;

public class RaceCondition {

    public static void main(final String[] args) throws Exception {
        int numberOfThreads = 100;
        for (int run = 0; run < 1000; run++) {
            System.out.printf("Run %05d.....", run + 1);
            Data data = new Data();

            List<Thread> threads = new ArrayList<>(numberOfThreads);
            for (int i = 0; i < numberOfThreads; i++) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        /*The solution, leave it commented out first to see 
                          if a race condition will take place or not*/
                        synchronized(data){
                        final int value = data.getValue();
                        data.setValue(value + 1);
                        }
                    }
                });
                thread.start();
                threads.add(thread);
            }

            //wait for all threads to finish execution and die
            for (Thread thread : threads) {
                thread.join();
            }

            if (data.getValue() == numberOfThreads) {
                System.out.println("Passed");
            } else {
                System.out.printf("Failed with value %d instead of %d%n", data.getValue(), numberOfThreads);
                break;
            }
        }
    }
}
