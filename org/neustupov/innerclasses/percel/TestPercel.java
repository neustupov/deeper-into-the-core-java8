package neustupov.innerclasses.percel;

public class TestPercel {

  public static void main(String[] args) {
    Parcel4 p = new Parcel4();
    Contents c = p.contents();
    Destination d = p.destination("Tans");
  }
}
