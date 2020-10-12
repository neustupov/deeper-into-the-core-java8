package neustupov.enums.typeOfFood;

public interface Food {

  enum Appetizer implements Food{
    SALAD,
    SOUP
  }

  enum Dessert implements Food{
    TIRAMISU,
    FRUIT
  }
}
