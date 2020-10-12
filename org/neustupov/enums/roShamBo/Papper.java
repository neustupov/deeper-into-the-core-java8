package neustupov.enums.roShamBo;

import static neustupov.enums.roShamBo.Outcome.DRAW;
import static neustupov.enums.roShamBo.Outcome.LOSE;
import static neustupov.enums.roShamBo.Outcome.WIN;

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
