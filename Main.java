import java.io.File;

/**
 * Created by Greg on 10.02.2017.
 */
public class Main {
    public static void main(String args[]){
        FileManager fm = new FileManager(new File("C:/Users/Greg/Desktop/input/test.zip"),4096,"C:/Users/Greg/Desktop/output");
        ProgressBar pb = new ProgressBar(fm);
        Thread threadOne = new Thread(fm);
        Thread threadTwo = new Thread(pb);
        threadTwo.setDaemon(true);
        threadOne.start();
        threadTwo.start();
    }
}
