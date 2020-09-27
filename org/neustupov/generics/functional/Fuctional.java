package neustupov.generics.functional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Fuctional {

  public static <T> T reduce(Iterable<T> seq, Combiner<T> combiner){
    Iterator<T> it = seq.iterator();
    if(it.hasNext()){
      T result = it.next();
      while (it.hasNext()){
        result = combiner.combine(result, it.next());
      }
      return result;
    }
    return null;
  }

  public static <T> Collector<T> forEach(Iterable<T> seq, Collector<T> func){
    for(T t : seq){
      func.function(t);
    }
    return func;
  }

  public static <R, T> List<R> transform(Iterable<T> seq, UnaryFunction<R, T> func){
    List<R> result = new ArrayList<>();
    for(T t : seq){
      result.add(func.function(t));
    }
    return result;
  }

  public static <T> List<T> filter(Iterable<T> seq, UnaryPredicate<T> pred){
    List<T> result = new ArrayList<>();
    seq.forEach(t -> {
      if (pred.test(t)){
        result.add(t);
      }
    });
    return result;
  }

  static class IntegerAdder implements Combiner<Integer>{

    @Override
    public Integer combine(Integer x, Integer y) {
      return x + y;
    }
  }

  static class IntegerSubtracter implements Combiner<Integer>{

    @Override
    public Integer combine(Integer x, Integer y) {
      return x - y;
    }
  }

  static class BigDecimalAdder implements Combiner<BigDecimal>{

    @Override
    public BigDecimal combine(BigDecimal x, BigDecimal y) {
      return x.add(y);
    }
  }

  static class BigIntegerAdder implements Combiner<BigInteger>{

    @Override
    public BigInteger combine(BigInteger x, BigInteger y) {
      return x.add(y);
    }
  }

  static class AtomicLongAdder implements Combiner<AtomicLong>{

    @Override
    public AtomicLong combine(AtomicLong x, AtomicLong y) {
      return new AtomicLong(x.addAndGet(y.get()));
    }
  }

  static class BigDecimalUlp implements UnaryFunction<BigDecimal, BigDecimal>{

    @Override
    public BigDecimal function(BigDecimal bigDecimal) {
      return bigDecimal.ulp();
    }
  }

  static class GreaterThan<T extends Comparable<T>> implements UnaryPredicate<T>{

    private T bound;

    public GreaterThan(T bound) {
      this.bound = bound;
    }

    @Override
    public boolean test(T x) {
      return x.compareTo(bound) > 0;
    }
  }

  static class MultiplyngIntegerCollector implements Collector<Integer>{
    private Integer val = 1;

    @Override
    public Integer result() {
      return val;
    }

    @Override
    public Integer function(Integer integer) {
      val *= integer;
      return val;
    }
  }

  public static void main(String[] args) {

    List<Integer> li = Arrays.asList(1,2,3,4,5,6,7);
    Integer result = reduce(li, new IntegerAdder());
    System.out.println(result);
    System.out.println(reduce(li, new IntegerSubtracter()));
    System.out.println(filter(li, new GreaterThan<>(4)));
    System.out.println(forEach(li, new MultiplyngIntegerCollector()).result());
    MathContext mc = new MathContext(7);
    List<BigDecimal> lbd = Arrays.asList(
        new BigDecimal(1.1, mc),
        new BigDecimal(2.2, mc),
        new BigDecimal(3.3, mc),
        new BigDecimal(4.4, mc)
    );
    System.out.println(reduce(lbd, new BigDecimalAdder()));
  }
}
