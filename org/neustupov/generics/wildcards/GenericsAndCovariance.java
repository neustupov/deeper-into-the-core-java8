package neustupov.generics.wildcards;

import java.util.ArrayList;
import java.util.List;

public class GenericsAndCovariance {

  public static void main(String[] args) {
    List<? extends Fruit> flist = new ArrayList<Apple>();
    Fruit f = flist.get(0);
  }
}
