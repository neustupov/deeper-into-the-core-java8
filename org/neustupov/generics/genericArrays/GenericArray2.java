package neustupov.generics.genericArrays;

public class GenericArray2<T> {

  private Object[] array;
  public GenericArray2(int sz){
    array = new Object[sz];
  }
  public void put(int index, T item){
    array[index] = item;
  }
  public T get(int index){
    return (T)array[index];
  }
  public T[] rep(){
    return (T[])array;
  }
}
