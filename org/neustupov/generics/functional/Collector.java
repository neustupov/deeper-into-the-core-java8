package neustupov.generics.functional;

public interface Collector<T> extends UnaryFunction<T, T> {

  T result();
}
