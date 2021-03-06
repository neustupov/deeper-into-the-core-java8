package neustupov.rtti.nullobjects;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

public class NullRobotProxyHandler implements InvocationHandler {

  private String nullName;
  private Robot proxied = new Nrobot();
  NullRobotProxyHandler(Class<? extends Robot> type){
    nullName = type.getSimpleName() + " NullRobot";
  }

  private class Nrobot implements Null, Robot {
    public String name(){
      return nullName;
    }
    public String model(){
      return nullName;
    }
    public List<Operation> operations(){
      return Collections.emptyList();
    }
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    return method.invoke(proxied, args);
  }
}
