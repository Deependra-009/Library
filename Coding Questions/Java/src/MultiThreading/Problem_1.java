package MultiThreading;

/*
* Print Alternate Letter and Number Sequence using 2 Threads
* */
public class Problem_1 {

    private static boolean printLetter=true;
    private static final Object object=new Object();

    public static void main(String args[]){

//        method1();

        method2();

    }

    private static void method2(){
        Runnable letterPrint=new Runnable() {
            @Override
            public void run() {
                for(char c='a';c<='z';c++){
                    synchronized (object){
                        if(!printLetter){
                            try {
                                object.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }

                        System.out.print(c+" ");
                        printLetter=false;
                        object.notify();
                    }
                }
            }
        };

        Runnable numberPrint=new Runnable(){
            @Override
            public void run() {
                for(int i=1;i<=26;i++){
                    synchronized (object){
                        if(printLetter){
                            try {
                                object.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }

                        System.out.print(i+" ");
                        printLetter=true;
                        object.notify();
                    }
                }
            }
        };

        Thread letterThread=new Thread(letterPrint);
        Thread numberThread =new Thread(numberPrint);

        letterThread.start();
        numberThread.start();
    }

    private static void method1(){
        Runnable letterPrint=new Runnable() {
            @Override
            public void run() {
                for(char c='a';c<='z';c++){
                    System.out.print(c+" ");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        Runnable numberPrint=new Runnable(){
            @Override
            public void run() {
                for(int i=1;i<=26;i++){
                    System.out.print(i+" ");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        Thread letterThread=new Thread(letterPrint);
        Thread numberThread =new Thread(numberPrint);

        letterThread.start();
        numberThread.start();
    }
}
