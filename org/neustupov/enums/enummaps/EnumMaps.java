package neustupov.enums.enummaps;

import java.util.EnumMap;
import java.util.Map;

public class EnumMaps {

  public static void main(String[] args) {
    EnumMap<AlarmPoints, Command> em = new EnumMap<>(AlarmPoints.class);
    em.put(AlarmPoints.KITCHEN, () -> System.out.println("Kitchen fire"));
    em.put(AlarmPoints.BATHROOM, () -> System.out.println("Bathroom fire"));
    for(Map.Entry<AlarmPoints, Command> e : em.entrySet()){
      System.out.println(e.getKey() + " : ");
      e.getValue().action();
    }
  }
}
