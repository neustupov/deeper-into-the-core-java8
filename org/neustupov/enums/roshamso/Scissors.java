package neustupov.enums.roshamso;

public class Scissors implements Item {

  @Override
  public Outcome complete(Item it) {
    return it.eval(this);
  }

  @Override
  public Outcome eval(Papper p) {
    return Outcome.LOSE;
  }

  @Override
  public Outcome eval(Scissors s) {
    return Outcome.DRAW;
  }

  @Override
  public Outcome eval(Rock r) {
    return Outcome.WIN;
  }

  @Override
  public String toString() {
    return "Scissors{}";
  }
}
