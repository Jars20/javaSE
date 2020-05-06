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

  public void setAnimal(Animal animal) {
    if (this.animal == null) {
      this.animal = animal;
      animal.frozen();
    } else {
      System.out.println("冰箱已经满了");
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