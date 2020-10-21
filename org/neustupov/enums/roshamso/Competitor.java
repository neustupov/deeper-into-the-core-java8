package neustupov.enums.roshamso;

public interface Competitor<T extends Competitor<T>> {

  Outcome compete(T competitor);
}
