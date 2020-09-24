package neustupov.generics;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ContainerMethodsDifference {

  static Set<String> methodSet(Class<?> type){
    Set<String> result = new TreeSet<>();
    for(Method m : type.getMethods()){
      result.add(m.getName());
    }
    return result;
  }

  static void interfaces(Class<?> type){
    System.out.println("Interfaces in " + type.getSimpleName() + ": ");
    List<String> result = new ArrayList<>();
    for(Class<?> c : type.getInterfaces()){
      result.add(c.getSimpleName());
    }
    System.out.println(result);
  }

  static Set<String> object = methodSet(Object.class);
  static {object.add("clone");}
  static void difference(Class<?> superset, Class<?> subset){
    System.out.println(superset.getSimpleName() + " extends " + subset.getSimpleName() + ", adds: ");
    Set<String> comp = Sets.difference(methodSet(superset), methodSet(subset));
    comp.removeAll(object);
    System.out.println(comp);
    interfaces(superset);
  }

  public static void main(String[] args) {
    interfaces(Collection.class);
    difference(HashSet.class, Set.class);
    difference(ArrayList.class, LinkedList.class);
  }
}
