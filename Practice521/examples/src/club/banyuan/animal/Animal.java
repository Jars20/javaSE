package club.banyuan.animal;

public abstract class Animal {

  private int heightInCM;

  public Animal() {
  }

  public Animal(int heightInCM) {
    this.heightInCM = heightInCM;
  }

  public abstract AnimalType getAnimalType();

  public int getHeightInCM() {
    return heightInCM;
  }

  public void setHeightInCM(int heightInCM) {
    this.heightInCM = heightInCM;
  }

}
