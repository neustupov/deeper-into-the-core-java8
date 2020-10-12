package neustupov.enums.roShamBo;

public interface Item {

  Outcome complete(Item it);
  Outcome eval(Papper p);
  Outcome eval(Scissors s);
  Outcome eval(Rock r);

}
