package club.banyuan.machine;

import club.banyuan.animal.Elephant;

public class Main {
  static Elephant createElephant(int heightInCM) {
    System.out.printf("创建一个大象，高度%d厘米\n", heightInCM);
    // 使用定义的类作为数据类型
    // 使用new 创建一个对象（实例）
    Elephant elephant = new Elephant();
    // 使用. 访问对象的属性，可以对属性赋值或使用
    elephant.setHeightInCM(heightInCM);
    return elephant;
  }

  static Fridge createFridge(int heightInCM) {
    System.out.printf("创建一个冰箱，高度%d厘米\n", heightInCM);
    Fridge fridge = new Fridge();
    fridge.setHeightInCM(heightInCM);
    return fridge;
  }

  static void putInElephant(Elephant elephant, Fridge fridge) {
    System.out.printf("把%d厘米高的大象装进%d厘米高的冰箱\n", elephant.getHeightInCM(), fridge.getHeightInCM());
    if(elephant.getHeightInCM() < fridge.getHeightInCM()) {

      // 使用对象方法
      fridge.setStorage(elephant);
      System.out.printf("冰箱里面的大象高度是%d厘米\n", fridge.getStorage().getHeightInCM());
    } else {
      System.out.printf("冰箱装不下!\n");
    }

  }

  public static void main(String[] args) {
    Elephant elephant = createElephant(300);
    Fridge fridge = createFridge(500);
    putInElephant(elephant, fridge); 
  }
}


