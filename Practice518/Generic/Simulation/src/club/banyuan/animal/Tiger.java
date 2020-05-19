package club.banyuan.animal;

public class Tiger extends Animal {

  public Tiger() {
    super(200);
  }

  public Tiger(int heightInCM) {
    super(heightInCM);
  }

  @Override
  public AnimalType getType() {
    return AnimalType.valueOfByTypeName("老虎");
  }

}
