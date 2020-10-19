package neustupov.multithreads.interruptingIdiom;

public class NeedsCleanup {
    private final int id;

    public NeedsCleanup(int id) {
        this.id = id;
        System.out.println("NeedsCleanup " + id);
    }
    public void cleanUp(){
        System.out.println("Cleaning up " + id);
    }
}
