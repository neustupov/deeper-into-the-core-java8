package neustupov.innerclasses.events;

import neustupov.innerclasses.events.GreenhouseControls.Terminate;

public class GreenhouseController {

  public static void main(String[] args) {
    GreenhouseControls gc = new GreenhouseControls();
    gc.addEvent(gc.new Bell(900));
    Event[] eventList = {
        gc.new ThermostatNight(0),
        gc.new LigthOn(200),
        gc.new LigthOff(400),
        gc.new WaterOn(600),
        gc.new WaterOff(800),
        gc.new ThermostatDay(1400)
    };
    gc.addEvent(gc.new Restart(200, eventList));
    if (args.length == 1) {
      gc.addEvent(new Terminate(new Integer(args[0])));
    }
    gc.run();
  }
}
