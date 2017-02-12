import java.io.*;

public class FileManager implements Runnable {
    private File input;
    private int buffer;
    private int progress;
    private boolean done;
    private String output;

    public FileManager() {
    }

    public FileManager(File input, int buffer, String output) {
        this.input = input;
        this.buffer = buffer;
        this.output = output;
        progress = 0;
        done = false;
    }

    @Override
    public void run() {
        copy();

    }
    public void copy(){
        File outputFile = new File(output+"/"+input.getName());
        System.out.print(outputFile.getAbsoluteFile());
        try(FileInputStream fis = new FileInputStream(input)) {
            outputFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(outputFile);
            byte[] buf = new byte[buffer]; int byteread = 0;
            for (; (byteread = fis.read(buf)) > 0;) {
                fos.write(buf, 0, byteread);
                progress++;
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File getInput() {
        return input;
    }

    public void setInput(File input) {
        this.input = input;
    }

    public int getBuffer() {
        return buffer;
    }

    public void setBuffer(int buffer) {
        this.buffer = buffer;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
}
