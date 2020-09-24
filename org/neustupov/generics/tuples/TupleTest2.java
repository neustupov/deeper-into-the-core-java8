package neustupov.generics.tuples;

import static neustupov.generics.tuples.Tuple.tuple;

public class TupleTest2 {

  static TwoTuple<String, Integer> f(){
    return tuple("hi", 47);
  }

  static TwoTuple f2(){
    return tuple("hi2", 42);
  }

  static ThreeTuple<Amphibian, String , Integer> g(){
    return tuple(new Amphibian(), "hi", 47);
  }

  public static void main(String[] args) {
    TwoTuple<String, Integer> ttsi = f();
    System.out.println(ttsi);
    System.out.println(f2());
    System.out.println(g());
  }
}
