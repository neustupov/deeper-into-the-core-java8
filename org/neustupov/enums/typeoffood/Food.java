package neustupov.enums.typeoffood;

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
