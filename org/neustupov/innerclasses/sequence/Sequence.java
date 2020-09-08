package neustupov.innerclasses.sequence;

import java.util.stream.IntStream;

public class Sequence {
  private Object[] items;
  private int next = 0;

  private Sequence(int size) {
    items = new Object[size];
  }

  private void add(Object x){
    if (next < items.length){
      items[next++] = x;
    }
  }

  interface Selector{
    boolean end();
    Object current();
    void next();
  }

  private class SequenceSelector implements Selector {
    private int i = 0;

    @Override
    public boolean end() {
      return i == items.length;
    }

    @Override
    public Object current() {
      return items[i];
    }

    @Override
    public void next() {
      if (i < items.length){
        i++;
      }
    }
  }

  private Selector selector(){
    return new SequenceSelector();
  }

  public static void main(String[] args) {
    Sequence sequence = new Sequence(10);
    IntStream.range(0, 11).forEach(x -> sequence.add(Integer.toString(x)));
    Selector selector = sequence.selector();
    while (!selector.end()){
      System.out.println(selector.current() + " ");
      selector.next();
    }
  }
}
