package neustupov.collection.generators.collectiondatatest;

import java.util.LinkedHashSet;
import java.util.Set;
import neustupov.collection.generators.CollectionData;

public class CollectionDataTest {

  public static void main(String[] args) {
    Set<String> set = new LinkedHashSet<>(
        new CollectionData<>(new Goverment(), 6)
    );
    System.out.println(set);
    set.addAll(CollectionData.list(new Goverment(), 6));
    System.out.println(set);
  }
}
