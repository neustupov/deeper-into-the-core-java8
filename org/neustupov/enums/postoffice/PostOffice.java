package neustupov.enums.postoffice;

import neustupov.enums.postoffice.Mail.Address;
import neustupov.enums.postoffice.Mail.GeneralDelivery;
import neustupov.enums.postoffice.Mail.Readability;
import neustupov.enums.postoffice.Mail.ReturnAddress;
import neustupov.enums.postoffice.Mail.Scannability;

public class PostOffice {

  enum MailHandler {
    GENERAL_DELIVERY {
      boolean handle(Mail m) {
        if (m.generalDelivery == GeneralDelivery.YES) {
          System.out.println("Using general delivery for " + m);
          return true;
        }
        return false;
      }
    },
    MACHINE_SCAN {
      boolean handle(Mail m) {
        if (m.scannability == Scannability.UNSCANNABLE) {
          return false;
        }
        if (m.address == Address.INCORRECT) {
          return false;
        }
        System.out.println("Delivering " + m + " automatically");
        return true;
      }
    },
    VISUAL_INSPECTION {
      boolean handle(Mail m) {
        if (m.readability == Readability.ILLEGIBLE) {
          return false;
        }
        if (m.address == Address.INCORRECT) {
          return false;
        }
        System.out.println("Delivering " + m + " normally");
        return true;
      }
    },
    RETURN_TO_SENDER {
      boolean handle(Mail m) {
        if (m.returnAddress == ReturnAddress.MISSING) {
          return false;
        }
        System.out.println("Returning " + m + " to sender");
        return true;
      }
    };

    abstract boolean handle(Mail m);
  }

  static void handle(Mail m){
    for(MailHandler handler : MailHandler.values()){
      if(handler.handle(m)){
        return;
      }
      System.out.println(m + " is a dead letter");
    }
  }

  public static void main(String[] args) {
    for (Mail mail : Mail.generator(10)){
      System.out.println(mail.details());
      handle(mail);
      System.out.println("*********************");
    }
  }
}
