package neustupov.generics.restrictions;

import java.awt.Color;

public class ColoredDimension<T extends Dimension & HasColor> {
  T item;
  ColoredDimension(T item){
    this.item = item;
  }
  T getItem(){
    return item;
  }
  Color color(){
    return item.getColor();
  }
  int getA(){
    return item.a;
  }
}
