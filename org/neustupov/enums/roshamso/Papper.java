package neustupov.enums.roshamso;

import static neustupov.enums.roshamso.Outcome.DRAW;
import static neustupov.enums.roshamso.Outcome.LOSE;
import static neustupov.enums.roshamso.Outcome.WIN;

public class Papper implements Item {

  @Override
  public Outcome complete(Item it) {
    return it.eval(this);
  }

  @Override
  public Outcome eval(Papper p) {
    return DRAW;
  }

  @Override
  public Outcome eval(Scissors s) {
    return WIN;
  }

  @Override
  public Outcome eval(Rock r) {
    return LOSE;
  }

  @Override
  public String toString() {
    return "Papper{}";
  }
}
