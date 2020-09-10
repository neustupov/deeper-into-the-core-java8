package neustupov.innerclasses.events;

import java.util.ArrayList;
import java.util.List;

class Controller {

  private List<Event> eventList = new ArrayList<>();
  void addEvent(Event c){
    eventList.add(c);
  }
  void run(){
    while (eventList.size() > 0){
      new ArrayList<>(eventList).forEach(e -> {
        if (e.ready()){
          System.out.println(e);
          e.action();
          eventList.remove(e);
        }
      });
    }
  }
}
