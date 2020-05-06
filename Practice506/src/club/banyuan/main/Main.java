package club.banyuan.main;

import club.banyuan.animal.Elephant;
import club.banyuan.animal.Lion;
import club.banyuan.animal.Tiger;
import club.banyuan.machine.Fridge;


public class Main {

  static void putInElephant(Elephant elephant, Fridge fridge) {
    System.out.printf("把%d厘米高的大象装进%d厘米高的冰箱\n", elephant.getHeightInCM(), fridge.getHeightInCM());
    if (elephant.getHeightInCM() < fridge.getHeightInCM()) {
      // 使用对象方法
      fridge.setAnimal(elephant);
      System.out.printf("冰箱里面的大象高度是%d厘米\n", fridge.getAnimal().getHeightInCM());
    } else {
      System.out.printf("冰箱装不下!\n");
    }
  }

  public static void main(String[] args) {
    // Elephant elephant = new Elephant(300);
    Fridge fridge = new Fridge(500);
    Elephant elephant = new Elephant();
    elephant.setHeightInCM(300);

    putInElephant(elephant, fridge);
    fridge.clear();
    Lion lion = new Lion();
    lion.setHeightInCM(200);
    fridge.setAnimal(lion);

    fridge.clear();
    Tiger tiger = new Tiger();
    fridge.setAnimal(tiger);
  }
}