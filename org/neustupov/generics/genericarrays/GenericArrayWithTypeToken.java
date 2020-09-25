package neustupov.generics.genericArrays;

import java.lang.reflect.Array;

public class GenericArrayWithTypeToken<T> {

  private T[] array;
  public GenericArrayWithTypeToken(Class<T> type, int size){
    array = (T[]) Array.newInstance(type, size);
  }
  public void put(int index, T item){
    array[index] = item;
  }
  public T get(int index){
    return array[index];
  }
  public T[] rep(){
    return array;
  }

  public static void main(String[] args) {
    GenericArrayWithTypeToken<Integer> rawti = new GenericArrayWithTypeToken<>(Integer.class, 10);
    Integer[] ai = rawti.rep();
  }
}
