package club.banyuan.machine;

import club.banyuan.animal.Animal;

public class Fridge {

  private int heightInCM;
  private Animal animal;

  public Fridge() {
    this(200);
  }

  public Fridge(int heightInCM) {
    this.heightInCM = heightInCM;
    System.out.printf("创建一个冰箱，高度%d厘米\n", heightInCM);
  }

  public void setAnimal(Animal animal) {
    if (animal instanceof Fridgeable) {
      this.animal = animal;
      Fridgeable fridgeable = (Fridgeable) animal;
      fridgeable.frozen(animal.getType());
    } else {
      System.out.println(animal.getType() + "不能被放入冰箱");
    }
  }

  public Animal getAnimal() {
    return animal;
  }

  public void setHeightInCM(int heightInCM) {
    this.heightInCM = heightInCM;
  }

  public int getHeightInCM() {
    return heightInCM;
  }

  @SuppressWarnings("unchecked")
  public <T> T getAnimalWithType() {
    return (T) animal;
  }
}


