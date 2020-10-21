package neustupov.enums.typeoffood;

import neustupov.enums.util.Enums;

public enum Course {

  APPETIZER(Food.Appetizer.class),
  DESSERT(Food.Dessert.class);

  private Food[] values;
  private Course(Class<? extends Food> kind){
    values = kind.getEnumConstants();
  }
  public Food randomSelection(){
    return Enums.random(values);
  }
}
