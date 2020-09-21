package neustupov.rtti.registeredFactories;

public class FuelFilter extends Filter {

  public static class Factory implements neustupov.rtti.registeredFactories.Factory<FuelFilter>{
    public FuelFilter create() {
      return new FuelFilter();
    }
  }
}
