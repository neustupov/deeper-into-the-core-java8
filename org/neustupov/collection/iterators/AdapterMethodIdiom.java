package neustupov.collection.iterators;

import java.util.Arrays;

public class AdapterMethodIdiom {

  public static void main(String[] args) {
    ReversibleArrayList<String> rai = new ReversibleArrayList<>(
        Arrays.asList("To be or not to be".split(" "))
    );
    for(String s : rai){
      System.out.print(s + " ");
    }
    System.out.println();
    for (String s : rai.reversed()){
      System.out.print(s + " ");
    }
  }
}
