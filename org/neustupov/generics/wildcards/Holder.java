package neustupov.generics.wildcards;

public class Holder<T> {

  private T value;
  public Holder(){}
  public Holder(T value){
    this.value = value;
  }
  public void set(T value){
    this.value = value;
  }
  public T get(){
    return value;
  }
  public boolean equals(Object obj){
    return value.equals(obj);
  }

  public static void main(String[] args) {
    Holder<Apple> Apple = new Holder<>(new Apple());
    Apple d = Apple.get();
    Apple.set(d);
    Holder<? extends Fruit> fruit = Apple;
  }
}
