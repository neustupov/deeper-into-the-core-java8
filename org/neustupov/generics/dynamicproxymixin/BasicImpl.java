package neustupov.generics.dynamicproxymixin;

public class BasicImpl implements Basic {

  private String value;

  @Override
  public void set(String val) {
   value = val;
  }

  @Override
  public String get() {
    return value;
  }
}
