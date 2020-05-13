package club.banyuan.machine;

import club.banyuan.animal.Animal;

public class Fridge {

  private int heightInCM;
  private Animal animal;

  public Fridge(int heightInCM) {

    System.out.printf("创建一个冰箱，高度%d厘米\n", heightInCM);
    this.heightInCM = heightInCM;
  }

  public Animal getAnimal() {
    return animal;
  }

  public boolean setAnimal(Animal animal) {
    if (this.animal == null) {
      if (animal instanceof Fridgeable) {
        this.animal = animal;
        ((Fridgeable) animal).frozen();
        return true;
      } else {
        System.out.println("不支持的动物类型" + animal.getAnimalType());
        return false;
      }
    } else {
      System.out.println("冰箱已经满了");
      return false;
    }
  }

  public void clear() {
    this.animal = null;
  }

  public int getHeightInCM() {
    return heightInCM;
  }

  public void setHeightInCM(int heightInCM) {
    this.heightInCM = heightInCM;
  }
}