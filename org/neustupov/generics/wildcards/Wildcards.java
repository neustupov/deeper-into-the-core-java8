package neustupov.generics.wildcards;

public class Wildcards {

  static void rawArgs(Holder holder, Object args) {
    holder.set(args);
    holder.set(new Wildcards());
    Object obj = holder.get();
  }

  static void unboundedArgs(Holder<?> holder, Object args){
  }

  static <T> T exact1(Holder<T> holder){
    T t = holder.get();
    return t;
  }

  static <T> T exact2(Holder<T> holder, T args){
    holder.set(args);
    T t = holder.get();
    return t;
  }

  static <T> T wildSubtype(Holder<? extends T> holder, T args){
    T t = holder.get();
    return t;
  }

  static <T> void wildSpertype(Holder<? super T> holder, T args){
    holder.set(args);
    Object obj = holder.get();
  }
}