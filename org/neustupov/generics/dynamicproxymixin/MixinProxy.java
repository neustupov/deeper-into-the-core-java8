package neustupov.generics.dynamicproxymixin;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import neustupov.generics.tuples.TwoTuple;

public class MixinProxy implements InvocationHandler {

  Map<String, Object> delegatesByMethod;
  public MixinProxy(TwoTuple<Object, Class<?>>... pairs){
    delegatesByMethod = new HashMap<>();
    for(TwoTuple<Object, Class<?>> pair : pairs){
      for(Method method : pair.second.getMethods()){
        String methodName = method.getName();
        delegatesByMethod.putIfAbsent(methodName, pair.first);
      }
    }
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    String methodName = method.getName();
    Object delegate = delegatesByMethod.get(methodName);
    return method.invoke(delegate, args);
  }

  public static Object newInstance(TwoTuple... pairs){
    Class[] interfaces = new Class[pairs.length];
    for(int i = 0; i < pairs.length; i++){
      interfaces[i] = (Class)pairs[i].second;
    }
    ClassLoader cl = pairs[0].first.getClass().getClassLoader();
    return Proxy.newProxyInstance(cl, interfaces, new MixinProxy(pairs));
  }
}
