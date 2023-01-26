package org.example;

public class DifferentWaysToCreateThread {

    public static class Thread1 extends Thread{
        public void run() {
            System.out.println("Example1 using Thread");
        }
    };

    public static class Runnable1 implements Runnable {

        @Override
        public void run() {
            System.out.println("Example2 using runnable");
        }
    }

    public static void executeExample1(){
        Thread1 thread1 = new Thread1();
        thread1.start();
    }

    public static void executeExample2(){
        Thread thread2 = new Thread(new Runnable1());
        thread2.start();
    }

    public static void  executeExample3(){
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Example3 running runnable using anonymous class");
            }
        });

        thread3.start();
    }

    public static void executeExample4(){
        Runnable runnable = () -> {
            System.out.println("Example4 running runnable using lambda expression");
        };

        Thread thread4 = new Thread(runnable);
        thread4.start();
    }
    public static void main() {
        executeExample1();
        executeExample2();
        executeExample3();
        executeExample4();
    }
}