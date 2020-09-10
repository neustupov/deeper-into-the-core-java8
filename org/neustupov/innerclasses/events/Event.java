package neustupov.innerclasses.events;

public abstract class Event {

  private long eventTime;
  final long delayTime;
  Event(long delayTime){
    this.delayTime = delayTime;
    start();
  }

  void start(){
    eventTime = System.nanoTime() + delayTime;
  }

  boolean ready(){
    return System.nanoTime() >= eventTime;
  }

  public abstract void action();
}
