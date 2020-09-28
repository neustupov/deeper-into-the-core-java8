package neustupov.collection.generators.collectiondatatest;

import neustupov.collection.generators.Generator;

public class Goverment implements Generator<String> {

  private String[] foundation = ("q w e r t y").split(" ");
  private int index;
  public String next(){
    return foundation[index++];
  }
}
