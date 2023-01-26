package org.example;

import java.util.stream.IntStream;

public class JoinThread {
    public static void sleepFor(long milli){
        try{
            Thread.sleep(milli);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main() {
        Runnable runnable = () -> {
            IntStream.range(0, 5).forEach(index -> {
                sleepFor(1000);
                System.out.printf("Executed %d time \n", index);
            });
        };

        Thread t1 = new Thread(runnable);
        t1.setDaemon(true);
        t1.start();

        try{
            t1.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
