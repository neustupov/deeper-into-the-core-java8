package neustupov.innerclasses.inmethods;

import neustupov.innerclasses.percel.Destination;

public class Parcel9 {

  Destination destination(final String dest){
    return new Destination() {
      private String label = dest;
      @Override
      public String readLabel() {
        return label;
      }
    };
  }

  public static void main(String[] args) {
    Parcel9 p = new Parcel9();
    Destination d = p.destination("Tans");
    System.out.println(d.readLabel());
  }
}
