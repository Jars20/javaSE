package club.banyuan.machine;

import club.banyuan.animal.AnimalType;

public interface Fridgeable {

  default void frozen(AnimalType name) {
    System.out.println(name + "被冻起来了");
  }
}
