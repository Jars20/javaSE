package club.banyuan.animal;

public class Animal {

  private int heightInCM;

  public int getHeightInCM() {
    return heightInCM;
  }

  public void setHeightInCM(int heightInCM) {
    this.heightInCM = heightInCM;
  }

  public void frozen() {
    System.out.println("animal frozen");
  }
}
