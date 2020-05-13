package club.banyuan.animal;

import club.banyuan.machine.Fridgeable;

public class Lion extends Animal implements Fridgeable {

  @Override
  public AnimalType getAnimalType() {
    return AnimalType.LION;
  }

  @Override
  public void frozen() {
    System.out.println("lion frozen");
  }

  public void lionMethod() {
    System.out.println("Lion method");
  }
}
