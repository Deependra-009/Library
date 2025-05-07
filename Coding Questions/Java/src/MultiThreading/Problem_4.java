package MultiThreading;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
* Developing a generic concurrent file reader program that can read data from multiple text files.
* concurrently using java's thread poll & executor framework
* */
public class Problem_4 {

    public static void main(String[] args) throws InterruptedException {

//        method1();
        method2();
    }

    private static void method2(){

        ExecutorService executorService= Executors.newFixedThreadPool(2);
        String filsPath[]={
                "src/OthersFiles/sampleFile1.txt",
                "src/OthersFiles/sampleFile2.txt",
                "src/OthersFiles/sampleFile3.txt"
        };

        for(String path:filsPath){
            executorService.execute(()->readFile(path));
        }

        executorService.shutdown();

    }

    private static void method1() throws InterruptedException {
        String file1Path = "src/OthersFiles/sampleFile1.txt";
        String file2Path = "src/OthersFiles/sampleFile2.txt";

        Thread file1Thread = new Thread(()->readFile(file1Path));
        Thread file2Thread = new Thread(()->readFile(file2Path));

        file1Thread.start();
        file2Thread.start();


        file1Thread.join();
        file2Thread.join();
    }

    private static void readFile(String filePath){
        try(BufferedReader br=new BufferedReader(new FileReader(filePath))){
            String line;
            while((line = br.readLine())!= null){
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + ": read line "+line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
