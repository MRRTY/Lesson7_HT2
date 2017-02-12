/**
 * Created by Greg on 10.02.2017.
 */
public class ProgressBar implements Runnable{
    private FileManager fm;

    public ProgressBar() {
    }

    public ProgressBar(FileManager fm) {
        this.fm = fm;
    }

    @Override
    public void run() {
        long size = fm.getInput().length();
        long buffer = fm.getBuffer();
        while (!fm.isDone()){
            long progress = fm.getProgress();
            System.out.println((buffer*progress*100)/size+"%");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
