package neustupov.exceptions.lostmessage;

public class LostMessage {

  void f()throws VeryImportantException{
    throw new VeryImportantException();
  }

  void dispose() throws NoHumException{
    throw new NoHumException();
  }

  public static void main(String[] args) {
    try{
      LostMessage lm = new LostMessage();
      try{
        lm.f();
      } finally {
        lm.dispose();
      }
    } catch (Exception e){
      System.out.println(e);
    }
  }
}
