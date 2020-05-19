package club.banyuan.main;

import club.banyuan.animal.Animal;
import club.banyuan.animal.AnimalType;
import club.banyuan.animal.Elephant;
import club.banyuan.animal.Lion;
import club.banyuan.animal.Tiger;
import club.banyuan.machine.Fridge;
import club.banyuan.machine.GenericFridge;

public class Main {

  static void putInAnimal(Animal animal, Fridge fridge) {
    System.out.printf("把%d厘米高的%s装进%d厘米高的冰箱\n", animal.getHeightInCM(), animal.getType(),
        fridge.getHeightInCM());
    if (animal.getHeightInCM() < fridge.getHeightInCM()) {
      fridge.setAnimal(animal);
      if (fridge.getAnimal() != null) {
        System.out.printf("冰箱里面的%s高度是%d厘米\n", animal.getType(), fridge.getAnimal().getHeightInCM());
      }
    } else {
      System.out.println("冰箱装不下!");
    }
  }

  static <T extends Animal> void putInAnimal(T animal, GenericFridge<T> fridge) {
    fridge.setAnimal(animal);
    System.out.printf("把%d厘米高的%s装进%d厘米高的冰箱\n", animal.getHeightInCM(), animal.getType(),
        fridge.getHeightInCM());
    if (animal.getHeightInCM() < fridge.getHeightInCM()) {
      fridge.setAnimal(animal);
      if (fridge.getAnimal() != null) {
        System.out.printf("冰箱里面的%s高度是%d厘米\n", animal.getType(), fridge.getAnimal().getHeightInCM());
      }
    } else {
      System.out.println("冰箱装不下!");
    }
  }

  public static void main(String[] args) {
    Elephant elephant = new Elephant(300);
    Fridge fridge = new Fridge(500);
    putInAnimal(elephant, fridge);

    Elephant elephant1 = fridge.getAnimalWithType();
    // Lion lion = fridge.getAnimalWithType();


    // GenericFridge<Fridge> genericFridge = new GenericFridge<>();
    // genericFridge.setAnimal(new Fridge());
    //
    // // putInAnimal(new Fridge(), genericFridge);
    //
    // Elephant elephant = new Elephant(300);
    // Fridge fridge = new Fridge(500);
    // putInAnimal(elephant, fridge);
    //
    // Animal animal = fridge.getAnimal();
    // if (animal instanceof Elephant) {
    //   Elephant elephant1 = (Elephant) animal;
    //   elephant1.elephantMethod();
    // }
    //
    // GenericFridge<Elephant> elephantGenericFridge = new GenericFridge<>();
    // elephantGenericFridge.setAnimal(elephant);
    // putInAnimal(elephant, elephantGenericFridge);
    //
    // Elephant animal1 = elephantGenericFridge.getAnimal();
    //
    // Fridge fridgeForLion = new Fridge(500);
    // Lion lion = new Lion();
    // putInAnimal(lion, fridgeForLion);
    //
    // GenericFridge<Lion> lionGenericFridge = new GenericFridge<>();
    // lionGenericFridge.setAnimal(lion);
    // putInAnimal(lion, lionGenericFridge);
    // Lion animal2 = lionGenericFridge.getAnimal();
    //
    // Fridge fridgeForTiger = new Fridge(500);
    // Tiger tiger = new Tiger();
    // putInAnimal(tiger, fridgeForTiger);

  }
}


