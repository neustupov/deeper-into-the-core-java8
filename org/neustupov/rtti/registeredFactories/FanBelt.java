package neustupov.rtti.registeredFactories;

public class FanBelt extends Belt {

  public static class Factory implements neustupov.rtti.registeredFactories.Factory<FanBelt>{
    public FanBelt create(){
      return new FanBelt();
    }
  }
}
