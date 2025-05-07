package MultiThreading;

/*
* Deadlock
* Check deadlock using cmd :
* run java program in terminal
* open new terminal and type 'ps -a' which gives you all process which is running
* type : jcmd process_id Thread.print
* */
public class Problem_2 {

    public static void main(String[] args) {
        Object object1=new Object();
        Object object2=new Object();

        Thread t1=new Thread(()->{
            synchronized (object2){
                System.out.println("t1 acquire object 2");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (object1){
                    System.out.println("t1 got object 2 key");
                }
            }
        });

        Thread t2=new Thread(()->{
            synchronized (object1){
                System.out.println("t2 acquire object 1");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (object2){
                    System.out.println("t2 got object 1 key");
                }
            }
        });

        t1.start();
        t2.start();

    }

}
