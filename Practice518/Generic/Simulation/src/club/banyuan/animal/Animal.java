package club.banyuan.animal;

public abstract class Animal {

  private int heightInCM;

  public abstract AnimalType getType();

  public Animal(int heightInCM) {
    this.heightInCM = heightInCM;
  }

  public void setHeightInCM(int heightInCM) {
    if (heightInCM <= 0) {
      System.out.println("传入的高度不合法!");
      return;
    }

    this.heightInCM = heightInCM;
  }

  public int getHeightInCM() {
    return heightInCM;
  }

}


