package neustupov.multithreads.dualsynch;

public class SyncObject {

    public static void main(String[] args) {
        final DualSynch ds = new DualSynch();
        new Thread(ds::f).start();
        ds.g();
    }
}
