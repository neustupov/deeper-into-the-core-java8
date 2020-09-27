package neustupov.generics.dynamictype;

public class Shape {

  public void rotate(){
    System.out.println(this + "rotate");
  }
  public void resize(int newSize){
    System.out.println(this + " resize " + newSize);
  }
}
