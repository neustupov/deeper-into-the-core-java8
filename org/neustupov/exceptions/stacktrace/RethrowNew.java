package neustupov.exceptions.stacktrace;

public class RethrowNew {

  public static void f() throws OneException {
    System.out.println("Exception in f()");
    throw new OneException("from f()");
  }

  public static void main(String[] args) {
    try {
      try {
        f();
      } catch (OneException e) {
        System.out.println("Catch in inner catch-block ");
        e.printStackTrace(System.out);
        throw new TwoException("From inner catch-block");
      }
    } catch (TwoException e) {
      System.out.println("Catch in outer catck-block");
      e.printStackTrace(System.out);
    }
  }
}
