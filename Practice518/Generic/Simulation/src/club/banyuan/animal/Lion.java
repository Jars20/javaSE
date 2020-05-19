package club.banyuan.animal;

import club.banyuan.machine.Fridgeable;

public class Lion extends Animal implements Fridgeable {

  public Lion() {
    this(200);
  }

  public Lion(int heightInCM) {
    super(heightInCM);
    setHeightInCM(heightInCM);
    System.out.printf("创建一个狮子，高度%d厘米\n", heightInCM);
  }

  @Override
  public AnimalType getType() {
    return AnimalType.valueOf(2);
  }
}


