package neustupov.rtti.registeredfactories;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Part {

  public String toString(){
    return getClass().getSimpleName();
  }

  static List<Factory<? extends Part>> partFactories = new ArrayList<>();
  static {
    partFactories.add(new FuelFilter.Factory());
    partFactories.add(new FanBelt.Factory());
  }

  private static Random rand = new Random(47);
  public static Part createRandom(){
    int i = rand.nextInt(partFactories.size());
    return partFactories.get(i).create();
  }
}
