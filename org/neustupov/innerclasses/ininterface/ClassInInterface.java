package neustupov.innerclasses.ininterface;

public interface ClassInInterface {

  void howdy();

  class Test implements ClassInInterface{

    @Override
    public void howdy() {
      System.out.println("Hello");
    }
  }

  public static void main(String[] args) {
    new Test().howdy();
  }
}
