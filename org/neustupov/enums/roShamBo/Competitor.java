package neustupov.enums.roShamBo;

public interface Competitor<T extends Competitor<T>> {

  Outcome compete(T competitor);
}
