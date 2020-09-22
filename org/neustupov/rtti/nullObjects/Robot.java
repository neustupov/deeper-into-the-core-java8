package neustupov.rtti.nullObjects;

import java.util.List;

public interface Robot {

  String name();

  String model();

  List<Operation> operations();

  class Test {

    public static void test(Robot r) {
      if (r instanceof Null) {
        System.out.println("[Null Robot]");
      }
      System.out.println(r.name());
      System.out.println(r.model());
      for (Operation o : r.operations()) {
        System.out.println(o.description());
        o.command();
      }
    }
  }
}
