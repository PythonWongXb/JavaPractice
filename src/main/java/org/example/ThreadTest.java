package org.example;


public class ThreadTest extends Thread {

    @Override
    public void run() {
        for( int i = 0; i < 1000; i++ ) {
            System.out.println(Thread.currentThread().getName() + ' ' + i);
        }
    }

    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        ThreadTest threadTest2 = new ThreadTest();

        threadTest.start();
        threadTest2.start();
        for( int i = 0; i < 100; i++ ) {
            System.out.println("im doing " + i );
        }
    }
}
