package neustupov.generics.dynamictype;

import java.lang.reflect.Method;

public class Apply {

  public static <T, S extends Iterable<? extends T>> void apply(S seq, Method f, Object... args){
    try{
      for(T t : seq){
        f.invoke(t, args);
      }
    } catch (Exception e){
      throw new RuntimeException(e);
    }
  }

}
