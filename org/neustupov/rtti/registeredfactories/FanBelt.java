package neustupov.rtti.registeredfactories;

public class FanBelt extends Belt {

  public static class Factory implements neustupov.rtti.registeredfactories.Factory<FanBelt>{
    public FanBelt create(){
      return new FanBelt();
    }
  }
}
