package neustupov.multithreads.pipedIO;

import java.io.IOException;
import java.io.PipedReader;

public class Receiver implements Runnable{

    private PipedReader in;
    public Receiver(Sender sender) throws IOException {
        in = new PipedReader(sender.getPipedWriter());
    }

    @Override
    public void run() {
        try{
            while (true){
                System.out.println("read " + (char)in.read() + " ");
            }
        } catch (IOException e){
            System.out.println("Receiver read exception");
        }
    }
}
