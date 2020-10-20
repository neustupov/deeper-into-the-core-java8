package neustupov.multithreads.notifyvsnotifyall;

public class Blocker {

    synchronized void waitingCall(){
        try{
            while (!Thread.interrupted()){
                wait();
                System.out.println(Thread.currentThread() + "");
            }
        } catch (InterruptedException e){
            System.out.println("Interrupted exception");
        }
    }
    synchronized void prod(){
        notify();
    }
    synchronized void prodAll(){
        notifyAll();
    }
}
