package neustupov.rtti.nullobjects;

import java.util.Arrays;
import java.util.List;

public class SnowRemovaRobot implements Robot {

  private String name;

  public SnowRemovaRobot(String name) {
    this.name = name;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public String model() {
    return "Snow Bot Series 11";
  }

  @Override
  public List<Operation> operations() {
    return Arrays.asList(new Operation() {
      @Override
      public String description() {
        return name + "can shovel snow";
      }

      @Override
      public void command() {
        System.out.println(name + "shoveling snow");
      }
    }, new Operation() {
      @Override
      public String description() {
        return name + "can chip ice";
      }

      @Override
      public void command() {
        System.out.println(name + "chipping ice");
      }
    });
  }

  public static void main(String[] args) {
    Robot.Test.test(new SnowRemovaRobot("Slusher"));
  }
}
