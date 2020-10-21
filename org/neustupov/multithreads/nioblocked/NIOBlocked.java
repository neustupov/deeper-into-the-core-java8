package neustupov.multithreads.nioblocked;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.SocketChannel;

public class NIOBlocked implements Runnable{
    private final SocketChannel sc;

    public NIOBlocked(SocketChannel sc) {
        this.sc = sc;
    }

    @Override
    public void run() {
        try {
            System.out.println("Waiting for read() in " + this);
            sc.read(ByteBuffer.allocate(1));
        } catch (ClosedByInterruptException e){
            System.out.println("ClosedByInterruptedException");
        } catch (AsynchronousCloseException e){
            System.out.println("AsynchronousCloseException");
        } catch (IOException e){
            throw new RuntimeException();
        }
        System.out.println("Exit NIOBlocked");
    }
}
