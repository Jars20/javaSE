package club.banyuan.animal;

public class Elephant extends Animal {

  public static final int DEFAULT_HEIGHT = 300;

  public Elephant() {
    this(DEFAULT_HEIGHT);
  }

  public Elephant(int heightInCM) {
    System.out.printf("创建一个大象，高度%d厘米\n", heightInCM);
    setHeightInCM(heightInCM);
  }

  public void setHeightInCM(int height) {
    if (height <= 100) {
      System.out.println("大象身高错误:" + height);
      return;
    }
    super.setHeightInCM(height);
  }

  @Override
  public void frozen() {
    System.out.println("Elephant frozen");
  }
}