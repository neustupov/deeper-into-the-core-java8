package neustupov.innerclasses.events;

public class GreenhouseControls extends Controller{

  private boolean light;
  public class LigthOn extends Event{
    public LigthOn(long delayTime){
      super(delayTime);
    }
    @Override
    public void action() {
      light = true;
    }
    @Override
    public String toString() {
      return "Light on";
    }
  }

  public class LigthOff extends Event{
    public LigthOff(long delayTime){
      super(delayTime);
    }
    @Override
    public void action() {
      light = false;
    }
    @Override
    public String toString() {
      return "Light off";
    }
  }

  private boolean water;
  public class WaterOn extends Event{
    public WaterOn(long delayTime){
      super(delayTime);
    }
    @Override
    public void action() {
      water = true;
    }
    @Override
    public String toString() {
      return "Water on";
    }
  }

  public class WaterOff extends Event{
    public WaterOff(long delayTime){
      super(delayTime);
    }
    @Override
    public void action() {
      water = false;
    }
    @Override
    public String toString() {
      return "Water off";
    }
  }

  private String thermostat = "day";
  public class ThermostatNight extends Event{
    public ThermostatNight(long delayTime){
      super(delayTime);
    }
    @Override
    public void action() {
      thermostat = "Night";
    }
    @Override
    public String toString() {
      return "Night";
    }
  }

  public class ThermostatDay extends Event{
    public ThermostatDay(long delayTime){
      super(delayTime);
    }
    @Override
    public void action() {
      thermostat = "Day";
    }
    @Override
    public String toString() {
      return "Day";
    }
  }

  public class Bell extends Event{
    Bell(long delayTime){
      super(delayTime);
    }
    @Override
    public void action() {
      addEvent(new Bell(delayTime));
    }
    @Override
    public String toString() {
      return "Boom!";
    }
  }

  public class Restart extends Event{
    private Event[] eventList;
    public Restart(long delayTime, Event[] eventList){
      super(delayTime);
      this.eventList = eventList;
      for (Event e : eventList){
        addEvent(e);
      }
    }

    @Override
    public void action() {
      for (Event e : eventList){
        e.start();
        addEvent(e);
      }
      start();
      addEvent(this);
    }

    @Override
    public String toString() {
      return "Restart";
    }
  }

  public static class Terminate extends Event{
    public Terminate(long delayTime){
      super(delayTime);
    }

    @Override
    public void action() {
      System.exit(0);
    }

    @Override
    public String toString() {
      return "Exit";
    }
  }
}
