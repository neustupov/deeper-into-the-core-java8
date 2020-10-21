package neustupov.rtti.registeredfactories;

public class RegisteredFactories {

  public static void main(String[] args) {
    for(int i = 0; i < 5; i++){
      System.out.println(Part.createRandom());
    }
  }
}
