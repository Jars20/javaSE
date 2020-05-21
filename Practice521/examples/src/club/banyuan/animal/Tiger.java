package club.banyuan.animal;

public class Tiger extends Animal {

  public Tiger() {
  }

  public Tiger(int heightInCM) {
    super(heightInCM);
  }

  @Override
  public AnimalType getAnimalType() {
    return AnimalType.TIGER;
  }

  public void tigerMethod() {
    System.out.println("Tiger method");
  }

  public int tigerHeight() {
    return getHeightInCM();
  }

  public int tigerHeightWithParam(int test) {
    return getHeightInCM();
  }

}
