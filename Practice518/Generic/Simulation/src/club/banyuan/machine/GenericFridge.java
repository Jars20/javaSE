package club.banyuan.machine;

public class GenericFridge<T> {

  private int heightInCM;
  private T animal;

  public GenericFridge() {
    this(200);
  }

  public GenericFridge(int heightInCM) {
    this.heightInCM = heightInCM;
    System.out.printf("创建一个冰箱，高度%d厘米\n", heightInCM);
  }

  public void setAnimal(T animal) {
    if (animal instanceof Fridgeable) {
      this.animal = animal;
      Fridgeable fridgeable = (Fridgeable) animal;
      // fridgeable.frozen(animal.getType());
    } else {
      // System.out.println(animal.getType() + "不能被放入冰箱");
    }
  }

  public T getAnimal() {
    return animal;
  }

  public void setHeightInCM(int heightInCM) {
    this.heightInCM = heightInCM;
  }

  public int getHeightInCM() {
    return heightInCM;
  }

}


