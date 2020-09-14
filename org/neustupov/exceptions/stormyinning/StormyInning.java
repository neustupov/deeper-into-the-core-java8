package neustupov.exceptions.stormyinning;

public class StormyInning extends Inning implements Storm {

  public StormyInning() throws RainedOut, BaseballException{}
  public StormyInning(String s) throws Foul, BaseballException{}
  public void rainHard() throws RainedOut{}
  public void event(){}
  public void atBat() throws PopFoul{}

  public static void main(String[] args) {
    try{
      StormyInning si = new StormyInning();
      si.atBat();
    } catch (PopFoul e){
      System.out.println("Pop");
    } catch (RainedOut e){
      System.out.println("Rain");
    } catch (BaseballException e){
      System.out.println("Baseball");
    }

    try{
      Inning i = new StormyInning();
      i.atBat();
    } catch (Strike e){
      System.out.println("Strike");
    } catch (Foul e){
      System.out.println("Foul");
    } catch (RainedOut e){
      System.out.println("Rain");
    } catch (BaseballException e){
      System.out.println("Baseball");
    }
  }
}
