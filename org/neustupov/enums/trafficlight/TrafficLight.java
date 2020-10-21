package neustupov.enums.trafficlight;

public class TrafficLight {

  private Signal color = Signal.RED;
  private void change(){
    switch (color){
      case RED: color = Signal.GREEN;
      break;
      case GREEN: color = Signal.YELLOW;
      break;
      case YELLOW: color = Signal.RED;
      break;
    }
  }

  @Override
  public String toString() {
    return "trafficLight{" +
        "color=" + color +
        '}';
  }

  public static void main(String[] args) {
    TrafficLight t = new TrafficLight();
    for(int i = 0; i < 7; i++){
      System.out.println(t);
      t.change();
    }
  }
}
