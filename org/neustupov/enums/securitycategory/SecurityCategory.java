package neustupov.enums.securitycategory;

import neustupov.enums.util.Enums;

public enum SecurityCategory {

  STOCK(Security.Stock.class),
  BOND(Security.Bond.class);

  Security[] values;

  SecurityCategory(Class<? extends Security> kind){
    values = kind.getEnumConstants();
  }

  interface Security {
    enum Stock implements Security {
      SHORT,
      LONG
    }
    enum Bond implements Security {
      MUNICIPAL,
      JUNK
    }
  }

  public Security randomSelection(){
    return Enums.random(values);
  }
}
