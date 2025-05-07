package MultiThreading;

import java.util.concurrent.atomic.AtomicInteger;

/*
* Implement a thread safe counter class that support increment & decrement operations.
* Multiple thread should be able to increment & decrement the counter concurrently without any race conditions
* */
public class Problem_3 {

    private static final AtomicInteger atomicInteger=new AtomicInteger(0);

    private volatile static int count=0;
    public static void main(String[] args) throws InterruptedException {

        int time=10000000;

        Thread incrementThread=new Thread(()->{
            for(int i=0;i<time;i++){
                atomicInteger.incrementAndGet();
//                count++;
            }
        });

        Thread decrementThread=new Thread(()->{
            for(int i=0;i<time;i++){
                atomicInteger.decrementAndGet();
//                count--;
            }
        });

        incrementThread.start();
        decrementThread.start();

        incrementThread.join();
        decrementThread.join();

        System.out.println("Final value : "+ atomicInteger);

    }

}
