package org.example;

public class StopRunnable {

    public static class StopableRunnable implements Runnable {
        private boolean isStoppable = false;

        private synchronized void setStoppable(boolean stoppable){
            this.isStoppable = stoppable;
        }

        private synchronized boolean isStoppable(){
            return this.isStoppable;
        }

        private void manualSleep(long millisecond){
            try{
                Thread.sleep(millisecond);
            } catch (Exception e){
                e.printStackTrace();
            }
        }


        @Override
        public void run() {
            while(!isStoppable()) {
                manualSleep(1000);
                System.out.println("Start now and dont stop");
            }
        }
    }

   public static void main() {
        StopableRunnable stopableRunnable = new StopableRunnable();
        Thread t1 = new Thread(stopableRunnable);
        t1.start();

        try{
            Thread.sleep(5000);
        } catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("Requesting stop");
        stopableRunnable.setStoppable(true);
        System.out.println("Stopped");
    }
}
