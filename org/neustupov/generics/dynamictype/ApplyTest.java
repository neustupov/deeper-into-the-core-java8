package neustupov.generics.dynamictype;

import java.util.ArrayList;
import java.util.List;

public class ApplyTest {

  public static void main(String[] args) throws Exception{
    List<Shape> shapes = new ArrayList<>();
    for(int i = 0; i < 10; i++){
      shapes.add(new Shape());
    }
    Apply.apply(shapes, Shape.class.getMethod("rotate"));
    Apply.apply(shapes, Shape.class.getMethod("resize", int.class), 5);
    List<Square> squeres = new ArrayList<>();
    for( int i = 0; i < 10; i++){
      squeres.add(new Square());
    }
    Apply.apply(squeres, Shape.class.getMethod("rotate"));
    Apply.apply(squeres, Shape.class.getMethod("resize", int.class), 5);

    Apply.apply(new FilledList<Shape>(Shape.class, 10), Shape.class.getMethod("rotate"));
    Apply.apply(new FilledList<Shape>(Square.class, 10), Shape.class.getMethod("rotate"));

    SimpleQueue<Shape> shapeQ = new SimpleQueue<>();
    for( int i = 0; i < 5; i++){
      shapeQ.add(new Shape());
      shapeQ.add(new Square());
    }
    Apply.apply(shapeQ, Shape.class.getMethod("rotate"));
  }
}
