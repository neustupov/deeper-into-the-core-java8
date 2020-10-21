package neustupov.rtti.registeredfactories;

public class FuelFilter extends Filter {

  public static class Factory implements neustupov.rtti.registeredfactories.Factory<FuelFilter>{
    public FuelFilter create() {
      return new FuelFilter();
    }
  }
}
