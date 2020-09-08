package neustupov.innerclasses.inmethods;

import neustupov.innerclasses.percel.Destination;

public class Parcel10 {

  public Destination destination(final String dest, final float price){
    return new Destination() {
      private int cost;
      {
        cost = Math.round(price);
        if (cost > 100){
          System.out.println(">>>>>");
        }
      }
      private String label = dest;
      @Override
      public String readLabel() {
        return label;
      }
    };
  }

  public static void main(String[] args) {
    Parcel10 p = new Parcel10();
    Destination d = p.destination("Tans", 101.1F);
    System.out.println(d.readLabel());
  }
}
