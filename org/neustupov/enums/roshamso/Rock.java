package neustupov.enums.roshamso;

public class Rock implements Item {

  @Override
  public Outcome complete(Item it) {
    return it.eval(this);
  }

  @Override
  public Outcome eval(Papper p) {
    return Outcome.WIN;
  }

  @Override
  public Outcome eval(Scissors s) {
    return Outcome.LOSE;
  }

  @Override
  public Outcome eval(Rock r) {
    return Outcome.DRAW;
  }

  @Override
  public String toString() {
    return "Rock{}";
  }
}
