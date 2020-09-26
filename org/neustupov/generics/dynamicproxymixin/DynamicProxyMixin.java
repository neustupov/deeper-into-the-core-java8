package neustupov.generics.dynamicproxymixin;

import static neustupov.generics.tuples.Tuple.tuple;

public class DynamicProxyMixin {

  public static void main(String[] args) {
    Object mixin = MixinProxy.newInstance(
        tuple(new BasicImpl(), Basic.class),
        tuple(new TimeStampedImpl(), TimeStamped.class)
    );
    Basic b = (Basic)mixin;
    TimeStamped t = (TimeStamped)mixin;
    b.set("Hello");
    System.out.println(b.get());
    System.out.println(t.getStamp());
  }
}
